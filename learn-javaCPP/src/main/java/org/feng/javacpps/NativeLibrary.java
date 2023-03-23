package org.feng.javacpps;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include = "c/NativeLibrary.h")
public class NativeLibrary {
    static {
        Loader.load();
    }

    public static native int add(int a, int b);

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = NativeLibrary.add(a, b);
        System.out.println(c); // Output: 5
    }
}