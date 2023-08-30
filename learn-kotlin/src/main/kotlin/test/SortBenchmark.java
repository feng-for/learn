package test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 5, time = 5)
@Fork(1)
@State(Scope.Thread)
public class SortBenchmark {

    @Param(value = {"100", "10000", "100000"})
    private int operationSize;


    private static List<Integer> arrayList;

    public static void main(String[] args) throws RunnerException {
        // 启动基准测试
        Options opt = new OptionsBuilder()
                .include(SortBenchmark.class.getSimpleName())
                .result("SortBenchmark.json")
                .mode(Mode.All)
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opt).run();
    }

    @Setup
    public void init() {
        arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < operationSize; i++) {
            arrayList.add(random.nextInt(10000));
        }
    }


    @Benchmark
    public void sort(Blackhole blackhole) {
        arrayList.sort(Comparator.comparing(e -> e));
        blackhole.consume(arrayList);
    }

    @Benchmark
    public void streamSorted(Blackhole blackhole) {
        arrayList = arrayList.stream().sorted(Comparator.comparing(e -> e)).collect(Collectors.toList());
        blackhole.consume(arrayList);
    }
}
