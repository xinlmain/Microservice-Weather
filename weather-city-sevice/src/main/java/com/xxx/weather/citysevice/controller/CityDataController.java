package com.xxx.weather.citysevice.controller;

import com.xxx.weather.citysevice.domain.City;
import com.xxx.weather.citysevice.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xin
 * @date 2018/9/10 21:23
 */
@RestController
@RequestMapping("/cities")
public class CityDataController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
