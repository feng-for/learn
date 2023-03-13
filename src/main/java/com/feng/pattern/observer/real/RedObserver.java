package com.feng.pattern.observer.real;

import com.feng.pattern.observer.AbstractObserver;
import com.feng.pattern.observer.Subject;

/**
 * @ClassName: RedObserver
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 23:10
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class RedObserver extends AbstractObserver {

    public RedObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    protected void update() {
        System.out.println("红色");
    }
}
