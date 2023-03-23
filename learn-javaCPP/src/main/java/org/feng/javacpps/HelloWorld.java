package org.feng.javacpps;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.NoException;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include = "stdio.h")
public class HelloWorld {

    static {
        Loader.load();
    }

    @Name("printf")
    @NoException
    public static native int printf(String format, Object... args);

    @Name("puts")
    @NoException
    public static native int puts(String s);

    public static void main(String[] args) {
        // HelloWorld.printf("Hello, %s!\n", "world");
        HelloWorld.puts("Hello, world\n");
    }
}
