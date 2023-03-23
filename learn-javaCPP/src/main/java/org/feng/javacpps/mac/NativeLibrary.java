package org.feng.javacpps.mac;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Namespace;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include="NativeLibrary.h",link="MyFunc")
@Namespace("NativeLibrary")
public class NativeLibrary {
    public static class MyFunc extends Pointer {
        static { Loader.load(); }
        public MyFunc() { allocate(); }
        private native void allocate();

        // to call add functions
        public native int add(int a, int b);
    }

    public static void main(String[] args) {
        MyFunc myFunc = new MyFunc();
        System.out.println(myFunc .add(111,222));
    }
}