package com.xxx.weather.reportservice.service;

import com.xxx.weather.common.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xin
 * @date 2018/9/12 22:15
 */
@FeignClient("weather-data-service")
@Deprecated
public interface WeatherClient {

    @GetMapping("/weather/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);

    @GetMapping("/weather/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName);
}
