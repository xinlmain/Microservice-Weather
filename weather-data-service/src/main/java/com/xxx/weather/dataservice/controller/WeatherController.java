package com.xxx.weather.dataservice.controller;

import com.xxx.weather.common.WeatherResponse;
import com.xxx.weather.dataservice.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xin
 * @date 2018/8/30 23:47
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
