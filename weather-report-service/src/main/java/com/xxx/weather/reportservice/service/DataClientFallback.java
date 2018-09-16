package com.xxx.weather.reportservice.service;

import com.xxx.weather.common.City;
import com.xxx.weather.common.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xin
 * @date 2018/9/16 11:21
 */
@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<City> listCity() throws Exception {
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setCityId("00");
        city.setCityName("无法获取城市信息");
        cityList.add(city);
        return cityList ;
    }

    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        return null;
    }

    @Override
    public WeatherResponse getWeatherByCityName(String cityName) {
        return null;
    }
}
