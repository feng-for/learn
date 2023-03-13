package com.gupaoedu.vip.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 帅气的景天老师
 * @create 2021/8/11 11:28
 */
@ConfigurationProperties(prefix = "gp.girl")
public class GirlProperties {
    private String name = "mic";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
