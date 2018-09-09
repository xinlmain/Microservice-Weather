package com.xxx.weather.collectionservice.config;

import com.xxx.weather.collectionservice.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz config
 *
 * @author xin
 * @date 2018/9/1 17:31
 */
@Configuration
public class QuartzConfiguration {

    private static final int TIME = 1800;

    // JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder).build();
    }
}
