package com.xxx.weather.citysevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCitySeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCitySeviceApplication.class, args);
    }
}
