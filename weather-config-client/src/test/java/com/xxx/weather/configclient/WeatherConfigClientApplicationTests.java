package com.xxx.weather.configclient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherConfigClientApplicationTests {

    @Value("${author}")
    private String author;

    @Test
    public void contextLoads() {
        Assert.assertEquals("waylau.com", author);
    }

}
