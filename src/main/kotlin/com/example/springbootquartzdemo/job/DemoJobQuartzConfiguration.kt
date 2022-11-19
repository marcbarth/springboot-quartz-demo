package com.example.springbootquartzdemo.job

import org.quartz.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DemoJobQuartzConfiguration {

    private val jobKey = "sampleJob"

    @Bean
    fun demoJobDetails(): JobDetail {
        return JobBuilder.newJob(DemoJob::class.java)
            .withIdentity(jobKey)
            .storeDurably().build()
    }

    @Bean
    fun demoJobTrigger(demoJobDetails: JobDetail?): Trigger {
        return TriggerBuilder
            .newTrigger()
            .forJob(demoJobDetails)
            .withIdentity(jobKey + "Trigger") //                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 1/1 * ? * * *"))
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
            .build()
    }

}