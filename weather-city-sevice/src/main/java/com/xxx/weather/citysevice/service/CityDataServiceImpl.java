package com.xxx.weather.citysevice.service;

import com.xxx.weather.citysevice.domain.City;
import com.xxx.weather.citysevice.domain.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import util.XmlBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author xin
 * @date 2018/9/1 22:50
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        // read xml file
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();

        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
