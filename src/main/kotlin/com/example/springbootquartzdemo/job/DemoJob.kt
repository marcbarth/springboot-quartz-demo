package com.example.springbootquartzdemo.job

import com.example.springbootquartzdemo.service.DemoService
import org.quartz.DisallowConcurrentExecution
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.beans.factory.annotation.Autowired

@DisallowConcurrentExecution //important if the job runs longer than trigger interval
class DemoJob : Job {
    @Autowired
    private val demoService: DemoService? = null
    override fun execute(context: JobExecutionContext) {
        demoService!!.printTime()
    }
}