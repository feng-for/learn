package com.zhiwei.pattern.observer.real;

import com.zhiwei.pattern.observer.AbstractObserver;
import com.zhiwei.pattern.observer.Subject;

/**
 * @ClassName: YellowObserver
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 23:13
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class YellowObserver extends AbstractObserver {

    public YellowObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    protected void update() {
        System.out.println("黄色");
    }
}
