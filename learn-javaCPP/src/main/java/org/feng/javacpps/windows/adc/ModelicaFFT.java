package org.feng.javacpps.windows.adc;

import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include="ModelicaFFT.c")
public class ModelicaFFT {

    static { System.setProperty("org.bytedeco.javacpp.logger.debug", "true"); Loader.load(); }

    public native int ModelicaFFT_kiss_fftr(DoublePointer u, long nu, DoublePointer work, long nwork, DoublePointer amplitudes, DoublePointer phases);

    public static void main(String[] args) {
        ModelicaFFT modelicaFFT = new ModelicaFFT();
        double[] u = new double[] {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};

        double[] work = new double[8];

        double[] amplitudes = new double[5];
        double[] phases = new double[5];

        int result = modelicaFFT.ModelicaFFT_kiss_fftr(
                new DoublePointer(u), u.length, new DoublePointer(work), work.length, new DoublePointer(amplitudes), new DoublePointer(phases)
        );

        System.out.println("Result: " + result);
    }
}
