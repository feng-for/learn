package com.feng.pattern;

/**
 * @ClassName: TemplatePattern
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 09:14
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public interface TemplatePattern {

    default void sleep(String name) {
        this.one(name);
        this.two(name);
        this.three(name);
        this.four(name);
    }


    void one(String name);

    void two(String name);

    void three(String name);

    void four(String name);
}
