package org.feng.javacv;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class FaceDetectionAndGrabcut {

    public static void main(String[] args) {
        try(PythonInterpreter interpreter = new PythonInterpreter();) {
            interpreter.execfile("learn-python3/one.py");

            // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
            PyFunction pyFunction = interpreter.get("id_photo", PyFunction.class);
            String picture = "222.jpeg";
            //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
            PyObject pyobj = pyFunction.__call__(new PyString(picture));
            System.out.println("the anwser is: " + pyobj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



