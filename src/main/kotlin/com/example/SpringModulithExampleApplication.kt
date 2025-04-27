package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.modulith.Modulith

@Modulith(sharedModules = arrayOf("shared"))
@SpringBootApplication
class SpringModulithExampleApplication

fun main(args: Array<String>) {
    runApplication<SpringModulithExampleApplication>(*args)
}
