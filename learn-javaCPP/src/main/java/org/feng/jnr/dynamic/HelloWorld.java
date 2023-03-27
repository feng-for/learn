package org.feng.jnr.dynamic;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Memory;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;
import jnr.ffi.Type;

public class HelloWorld {

    // static {
    //     System.loadLibrary("snprintf");
    //     System.loadLibrary("ModelicaStandardTablesUsertab");
    // }

    // 定义动态链接库中的导出函数
    public interface MyLibrary {
        int ModelicaFFT_kiss_fftr(Pointer u, long nu, Pointer work, long nwork, Pointer amplitudes, Pointer phases);
    }

    public static void main(String[] args) {
        String property = System.getProperty("java.library.path");
        System.out.println(property.replaceAll(";", "\n"));
        LibC libc = LibraryLoader.create(LibC.class).load("msvcrt"); // load the "c" library into the libc variable
        libc.puts("Hello World!"); // prints "Hello World!" to console
        System.out.println(libc.pow(2.0, 2.0));

        // System.load("C:\\Users\\Fengzhiwei\\.jdks\\corretto-11.0.18\\bin\\libzlib.a");
        MyLibrary lib = LibraryLoader.create(MyLibrary.class).load("ModelicaFFT");
        // 准备输入数组
        double[] u = new double[] {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};

        // 准备工作数组
        double[] work = new double[8];

        // 准备输出数组
        double[] amplitudes = new double[5];
        double[] phases = new double[5];

        // 分配内存，并创建指向该内存的指针
        Pointer uPtr = Memory.allocate(Runtime.getSystemRuntime(), u.length);
        Pointer workPtr = Memory.allocate(Runtime.getSystemRuntime(), work.length);
        Pointer ampPtr = Memory.allocate(Runtime.getSystemRuntime(), amplitudes.length);
        Pointer phasePtr = Memory.allocate(Runtime.getSystemRuntime(), phases.length);

        // 调用动态链接库中的导出函数
        int result = lib.ModelicaFFT_kiss_fftr(uPtr, u.length, workPtr, work.length, ampPtr, phasePtr);

        // 输出结果
        System.out.println("Result: " + result);
    }
}