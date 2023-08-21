package org.feng.demo;

public class JavaVMStackOOM {

    private void dontStop() { while (true) { } }

    private void stackLeakByThread(){
        while (true) {
            new Thread(this::dontStop).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.dontStop();
    }
}
