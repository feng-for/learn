package com.feng.pattern.observer;

import com.feng.pattern.observer.real.RedObserver;
import com.feng.pattern.observer.real.YellowObserver;

/**
 * @ClassName: Test
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 23:14
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new RedObserver(subject);
        new YellowObserver(subject);

        subject.setAge(18);
    }
}
