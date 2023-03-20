package org.feng.jnr;

import jnr.ffi.LibraryLoader;
import jnr.ffi.LibraryOption;
import jnr.ffi.Platform;
import jnr.posix.POSIX;
import jnr.posix.POSIXFactory;

import java.util.HashMap;
import java.util.Map;

public class JNRTest {

    // private static final POSIX posix = POSIXFactory.getPOSIX();

    public static void main(String[] args) {

        System.loadLibrary("jffi-1.2");

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

        final String pwdKey = "PWD"; // key for working directory
        final String shellKey = "SHELL"; // key for system shell (bash, zsh etc)

        String pwd = libc.getenv(pwdKey);
        System.out.println(pwd); // prints current directory

        libc.setenv(pwdKey, "/", true); // set PWD to /
        System.out.println(libc.getenv(pwdKey)); // prints /

        libc.unsetenv(pwdKey); // unset PWD
        System.out.println(libc.getenv(pwdKey)); // prints null (it is null not the String "null")

        System.out.println(libc.getenv(shellKey)); // prints system shell, /bin/bash on most Unixes
        libc.clearenv(); // clear all environment variables
        System.out.println(libc.getenv(shellKey)); // prints null (it is null not the String "null")
        System.out.println(libc.getenv("_")); // even the special "_" environment variable is now null
    }
}
