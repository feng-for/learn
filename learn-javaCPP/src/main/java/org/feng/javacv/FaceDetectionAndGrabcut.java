package org.feng.javacv;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FaceDetectionAndGrabcut {

    public static void main(String[] args) {
        // jPython();
        processBuilder();
    }

    private static void processBuilder() {
        try {
            List<String> command = new ArrayList<>();
            command.add("python3"); // 指定要执行的Python解释器
            command.add("learn-python3/one.py"); // 指定要执行的Python脚本路径
            command.add("/Users/wei/Documents/learn/learn/learn-python3/image/444.jpeg"); // 传递的第一个参数
            command.add("/Users/wei/Documents/learn/learn/test.jpg"); // 传递的第二个参数
            command.add(""); // 传递的第三个参数

            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jPython() {
        try(PythonInterpreter interpreter = new PythonInterpreter();) {
            interpreter.execfile("learn-python3/one.py");

            // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
            PyFunction pyFunction = interpreter.get("id_photo", PyFunction.class);
            String picture = "/Users/wei/Documents/learn/learn/learn-python3/image/444.jpeg";
            //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
            PyObject pyobj = pyFunction.__call__(new PyString(picture));
            System.out.println("the anwser is: " + pyobj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



