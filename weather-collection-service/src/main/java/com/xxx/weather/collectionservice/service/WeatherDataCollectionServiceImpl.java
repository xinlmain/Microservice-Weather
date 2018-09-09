package com.xxx.weather.collectionservice.service;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.jcs.utils.zip.CompressionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

/**
 * @author xin
 * @date 2018/9/9 10:53
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIMEOUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri) {
        String key = uri;
        String responseString = null;

        ResponseEntity<byte[]> response = restTemplate.getForEntity(uri, byte[].class);
        GZIPInputStream gzip = null;
        try {
            byte[] bytes = CompressionUtil.decompressGzipByteArray(response.getBody());
            /*gzip = new GZIPInputStream(new ByteArrayInputStream(response.getBody()));
            StringWriter writer = new StringWriter();
            */
            /* 使用原生类
            BufferedReader reader = new BufferedReader(new InputStreamReader(gzip, Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }*/

            /* 使用IOUtils方法
            IOUtils.copy(gzip, writer, "UTF-8");*/
            responseString = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, responseString, TIMEOUT, TimeUnit.SECONDS);
    }
}
