package com.xxx.weather.common;

import java.io.Serializable;

/**
 * 天气响应对象.
 * @author xin
 * @date 2018/8/30 22:34
 */
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather data;
    private int status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
