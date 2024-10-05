package com.example

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

@SpringBootTest
class SpringModulithExampleApplicationTests {

    val modules = ApplicationModules.of(SpringModulithExampleApplication::class.java)
    @Test
    fun printModuleArrangement() {

        modules.forEach{
            print(it)
        }

    }

    @Test
    fun verifyModularStructure() {modules.verify()}


    @Test
    fun writeDocumentation(){ Documenter(modules).writeDocumentation() }

}
