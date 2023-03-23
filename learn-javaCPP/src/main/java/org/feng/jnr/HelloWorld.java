package org.feng.jnr;

import jnr.ffi.LibraryLoader;
import jnr.ffi.byref.ByteByReference;
import jnr.ffi.byref.IntByReference;

import java.nio.charset.StandardCharsets;

public class HelloWorld {

    // static {
    //     System.loadLibrary("snprintf");
    //     System.loadLibrary("ModelicaStandardTablesUsertab");
    // }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        LibC libc = LibraryLoader.create(LibC.class).load("msvcrt"); // load the "c" library into the libc variable
        libc.puts("Hello World!"); // prints "Hello World!" to console
        System.out.println(libc.pow(2.0, 2.0));

        try {
            LibraryLoader.create(Snprintf.class).load("ModelicaFFT"); // load the "c" library into the libc variable
            System.out.println("成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ModelicaStandardTablesUsertab modelicaStandardTablesUsertab = LibraryLoader.create(ModelicaStandardTablesUsertab.class).load("ModelicaStandardTablesUsertab");// load the "c" library into the libc variable
            double[][] matrix = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
            int i = modelicaStandardTablesUsertab.USERTAB_NAME(new ByteByReference(), 1, new int[]{1}, new IntByReference(1), matrix);
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            LibraryLoader.create(Snprintf.class).load("win32_dirent"); // load the "c" library into the libc variable
            System.out.println("成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Snprintf snprintf = LibraryLoader.create(Snprintf.class).load("snprintf");// load the "c" library into the libc variable
            System.out.println(snprintf.getnumsep(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}