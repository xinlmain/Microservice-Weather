package com.xxx.weather.reportservice.service;

import com.xxx.weather.common.Forecast;
import com.xxx.weather.common.Weather;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xin
 * @date 2018/9/1 23:27
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getDataByCityId(String cityId) {
        // TODO: use weather data service.
        Weather data = new Weather();
        data.setAqi("81");
        data.setCity("深圳");
        data.setGanmao("容易感冒！多穿衣。");
        data.setWendu("22");
        List<Forecast> forecastList = new ArrayList<>();
        Forecast forecast = new Forecast();
        forecast.setDate("29日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecastList.add(forecast);
        data.setForecast(forecastList);
        return data;

        //return weatherDataService.getDataByCityId(cityId).getData();
    }
}
