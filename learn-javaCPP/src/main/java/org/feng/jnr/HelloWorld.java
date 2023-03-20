package org.feng.jnr;
import jnr.ffi.LibraryLoader;

public class HelloWorld {

    public static void main(String[] args) {
        LibC libc = LibraryLoader.create(LibC.class).load("msvcrt"); // load the "c" library into the libc variable
        libc.puts("Hello World!"); // prints "Hello World!" to console
        System.out.println(libc.pow(2.0, 2.0));
    }
}