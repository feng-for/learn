package org.feng.javacpps;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

@Platform(include="NativeLibrary.h",link="MyFunc")
@Namespace("NativeLibrary")
public class NativeLibrary {
    public static class MyFunc extends Pointer {
        static {
            Loader.load();
        }
        public MyFunc() { allocate(); }
        private native void allocate();

        // to call add functions
        public native int add(int a, int b);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        MyFunc myFunc = new MyFunc();
        System.out.println(myFunc.add(111,222));
    }
}