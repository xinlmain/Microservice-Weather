package com.xxx.weather.collectionservice.service;

import com.xxx.weather.common.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author xin
 * @date 2018/9/12 22:15
 */
@FeignClient("weather-city-service")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
