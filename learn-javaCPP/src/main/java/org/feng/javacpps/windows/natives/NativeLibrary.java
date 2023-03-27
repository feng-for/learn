package org.feng.javacpps.windows.natives;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

@Platform(include="NativeLibrary.h")
@Namespace("NativeLibrary")
public class NativeLibrary {
    static { System.setProperty("org.bytedeco.javacpp.logger.debug", "true"); }
    public static class NativeClass extends Pointer {
        static { Loader.load(); }
        public NativeClass() { allocate(); }
        private native void allocate();

        // to call the getter and setter functions
        public native @StdString String get_property(); public native void set_property(String property);

        // to access the member variable directly
        public native @StdString String property();     public native void property(String property);
    }

    public static void main(String[] args) {
        // Pointer objects allocated in Java get deallocated once they become unreachable,
        // but C++ destructors can still be called in a timely fashion with Pointer.deallocate()
        NativeClass l = new NativeClass();
        l.set_property("Hello World!!!");
        System.out.println(l.property());
    }
}
