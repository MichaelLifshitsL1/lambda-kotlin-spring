package com.demo

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import org.springframework.cloud.function.adapter.aws.SpringBootApiGatewayRequestHandler

class Handler : SpringBootApiGatewayRequestHandler(Application::class.java) {
    override fun handleRequest(event: APIGatewayProxyRequestEvent?, context: Context?): Any {
        println("+++++++++++++++++Handler ${event?.body}")
        System.setProperty("function.name", Application::function.name)
        return super.handleRequest(event, context)
    }
}