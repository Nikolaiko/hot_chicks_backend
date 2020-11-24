package com.hot.chicksbackend

import com.github.cloudyrock.spring.v5.EnableMongock
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableMongock
@SpringBootApplication
class HotchicksbackendApplication

fun main(args: Array<String>) {
	runApplication<HotchicksbackendApplication>(*args)
}
