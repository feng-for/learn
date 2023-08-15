package org.feng.demo;

/**
 * -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    private void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable throwable) {
            System.out.printf("stackLength: %d\n", javaVMStackSOF.stackLength);
            throwable.printStackTrace();
        }
    }
}
