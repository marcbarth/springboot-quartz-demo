package com.example.springbootquartzdemo.service

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DemoService {
    fun printTime() {
        println(LocalDateTime.now())
    }
}