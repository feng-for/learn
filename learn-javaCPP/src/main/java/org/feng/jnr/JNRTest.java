package org.feng.jnr;

import jnr.ffi.LibraryLoader;
import jnr.ffi.LibraryOption;
import jnr.ffi.Platform;
import org.feng.jnr.dynamic.LibC;

import java.util.HashMap;
import java.util.Map;

public class JNRTest {

    // private static final POSIX posix = POSIXFactory.getPOSIX();

    public static void main(String[] args) {

        // System.out.println(posix.getcwd());
        // posix.chdir("..");
        // System.out.println(posix.getcwd());
        // System.out.println(posix.getpid());

        // Add library options to customize library behavior
        Map<LibraryOption, Object> libraryOptions = new HashMap<>();
        libraryOptions.put(LibraryOption.LoadNow, true); // load immediately instead of lazily (ie on first use)
        libraryOptions.put(LibraryOption.IgnoreError, true); // calls shouldn't save last errno after call
        String libName = Platform.getNativePlatform().getStandardCLibraryName(); // platform specific name for libC
        System.out.println(libName);
        LibC libc = LibraryLoader.loadLibrary(
                LibC.class,
                libraryOptions,
                libName
        );

        libc.puts("Hello World!"); // prints "Hello World!" to console
        System.out.println(libc.pow(2.0, 2.0));
    }
}
