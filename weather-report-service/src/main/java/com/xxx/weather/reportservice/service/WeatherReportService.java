package com.xxx.weather.reportservice.service;

import com.xxx.weather.common.Weather;

/**
 * @author xin
 * @date 2018/9/1 23:26
 */
public interface WeatherReportService {

    /**
     * 根据city Id返回天气
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
