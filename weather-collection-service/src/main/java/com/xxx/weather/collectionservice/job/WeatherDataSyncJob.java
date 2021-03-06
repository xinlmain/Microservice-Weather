package com.xxx.weather.collectionservice.job;

import com.xxx.weather.collectionservice.service.CityClient;
import com.xxx.weather.collectionservice.service.WeatherDataCollectionService;
import com.xxx.weather.common.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xin
 * @date 2018/9/1 17:29
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityClient cityClient;

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start!");
        // get city list
        List<City> cityList = null;

        try {
            cityList = cityClient.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // enumerate city list, update weather
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, city id:" + cityId);
            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End!");
    }
}
