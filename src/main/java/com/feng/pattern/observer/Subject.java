package com.feng.pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: Subject
 * @Description: 主题、被观察者
 * @Author: wei
 * @DateTime: 2022/12/28 22:59
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class Subject {

    private List<AbstractObserver> abstractObservers = new ArrayList<>();

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.notifyObservers();
    }

    /**
     * 添加观察者
     * @param observer
     */
    public void addObserver(AbstractObserver observer) {
        this.abstractObservers.add(observer);
    }

    /**
     * 通知观察者
     */
    public void notifyObservers(){
        abstractObservers.stream().filter(Objects::nonNull).forEach(AbstractObserver::update);
    }
}
