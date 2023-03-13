package com.gupaoedu.vip.redisson;

/**
 * @author 帅气的景天老师
 * @create 2022/1/14 22:55
 */
public class Girl implements Humen{

    public static Girl create(String name){
        return new Girl(name);
    }

    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String dancing() {
        return name+"喜欢跳舞";
    }
}
