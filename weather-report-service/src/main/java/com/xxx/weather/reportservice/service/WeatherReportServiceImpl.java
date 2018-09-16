package com.xxx.weather.reportservice.service;

import com.xxx.weather.common.Forecast;
import com.xxx.weather.common.Weather;
import com.xxx.weather.common.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xin
 * @date 2018/9/1 23:27
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weatherResponse = dataClient.getWeatherByCityId(cityId);
        if (weatherResponse != null)
            return weatherResponse.getData();
        else return null;
    }
}
