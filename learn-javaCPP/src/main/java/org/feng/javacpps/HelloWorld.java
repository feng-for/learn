package org.feng.javacpps;

import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.NoException;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include = "stdio.h")
public class HelloWorld {
    @Name("printf")
    @NoException
    public static native int printf(String format, Object... args);

    public static void main(String[] args) {
        HelloWorld.printf("Hello, %s!\n", "world");
    }
}
