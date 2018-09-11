package com.xxx.weather.citysevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeatherCitySeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCitySeviceApplication.class, args);
    }
}
