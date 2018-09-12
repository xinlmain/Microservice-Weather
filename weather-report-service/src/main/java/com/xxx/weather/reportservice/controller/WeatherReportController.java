package com.xxx.weather.reportservice.controller;

import com.xxx.weather.common.City;
import com.xxx.weather.reportservice.service.CityClient;
import com.xxx.weather.reportservice.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xin
 * @date 2018/8/30 23:47
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityClient cityClient;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        List<City> cityList = cityClient.listCity();
        model.addAttribute("title", "xxx的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
