package com.feng.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/29 02:34
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneSimple cloneSimple = new CloneSimple();
        cloneSimple.setName("雏田");
        cloneSimple.setAge(18);
        List<String> addrs = new ArrayList<>();
        addrs.add("123");
        addrs.add("456");
        cloneSimple.setAddr(addrs);

        CloneSimple clone = cloneSimple.clone();
        System.out.println(clone.getAddr() == cloneSimple.getAddr());

        CloneSimple deepClone = cloneSimple.deepClone();
        System.out.println(deepClone.getAddr() == cloneSimple.getAddr());
    }
}
