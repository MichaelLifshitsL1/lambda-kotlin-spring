package com.demo

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.messaging.support.GenericMessage
import java.util.function.Function

@SpringBootApplication
class Application {

    @Bean
    fun function(objectMapper: ObjectMapper): Function<Message<Any>, Message<String>> {
        return Function {
            GenericMessage("Called!!! ${it.payload}",
                    mapOf("Content-type" to "text/plain",
                            "statusCode" to 200))
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}