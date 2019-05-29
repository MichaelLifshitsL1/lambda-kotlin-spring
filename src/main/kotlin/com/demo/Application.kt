package com.demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.messaging.support.GenericMessage
import java.util.function.Function

@SpringBootApplication
class Application {

    @Bean
    fun function(): Function<Message<Any>, Message<String>> {
        return Function {
            GenericMessage("Called!!! ${it.payload}",
                    mapOf("Content-type" to "text/plain",
                            "statusCode" to 200))
        }
    }

    @Bean
    fun getMapper(): ObjectMapper = jacksonObjectMapper().registerModule(JavaTimeModule())
}

fun main(vararg args: String) {
    runApplication<Application>(*args)
}
