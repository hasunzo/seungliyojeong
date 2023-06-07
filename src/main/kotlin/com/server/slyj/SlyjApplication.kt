package com.server.slyj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SlyjApplication

fun main(args: Array<String>) {
	runApplication<SlyjApplication>(*args)
}
