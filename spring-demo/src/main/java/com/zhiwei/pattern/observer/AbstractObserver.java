package com.zhiwei.pattern.observer;

/**
 * @ClassName: AbstractObserver
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 23:00
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public abstract class AbstractObserver {

    protected Subject subject;

    protected  abstract void update();
}
