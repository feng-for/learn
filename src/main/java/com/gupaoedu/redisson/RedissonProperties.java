package com.gupaoedu.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 帅气的景天老师
 * @create 2021/8/11 11:28
 */
@ConfigurationProperties(prefix = "gp.redisson")
public class RedissonProperties {

    private String host="127.0.0.1";
    private int port=6379;
    private int timeout;//超时时间
    private String pwd="";
    private int datasource=0;
    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getDatasource() {
        return datasource;
    }

    public void setDatasource(int datasource) {
        this.datasource = datasource;
    }
}
