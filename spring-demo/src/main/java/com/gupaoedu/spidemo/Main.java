package com.gupaoedu.spidemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        String methodName = "myMethod";
        Class<?>[] parameterTypes = {String.class, int.class};
        Object[] arguments = {"Hello", 42};

        Class<?> targetClass = MyClass.class;
        Method method = targetClass.getMethod(methodName, parameterTypes);
        Object targetObject = targetClass.getDeclaredConstructor().newInstance();
        Object result = method.invoke(targetObject, arguments);
        System.out.println("Result: " + result);

        Class<?> aClass = Class.forName("cn.catarc.modelica.modelicajunit.MyClass");
        Method method1 = aClass.getMethod(methodName, parameterTypes);
        Object o = aClass.getDeclaredConstructor().newInstance();
        Object invoke = method1.invoke(o, arguments);
        System.out.println("Method1: " + invoke);

        Method me = aClass.getMethod("me", Map.class, ArrayList.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "雏田");
        map.put("age", 18);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("雏田");
        strings.add("18");
        me.invoke(o, map, strings);

    }
}

class MyClass {
    public String myMethod(String message, int value) {
        return message + " " + value;
    }

    public void me(Map<String, Object> map, ArrayList<String> arrayList){
        Object[] array = map.values().toArray(new Object[]{});
        System.out.printf("my name is %s, my age is %s\n", array[0], array[1]);
        arrayList.forEach(System.out::println);
    }
}
