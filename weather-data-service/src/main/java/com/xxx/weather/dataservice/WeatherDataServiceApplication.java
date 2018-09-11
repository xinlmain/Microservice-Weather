package com.xxx.weather.dataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeatherDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataServiceApplication.class, args);
    }
}
