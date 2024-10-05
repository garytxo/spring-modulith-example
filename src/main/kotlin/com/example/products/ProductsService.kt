package com.example.products

import com.example.orders.domain.event.OrderPlacedEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service

@Service
internal class ProductsService {

    private val logger = LoggerFactory.getLogger(ProductsService::class.java)

    @ApplicationModuleListener
    fun on(orderPlacedEvent: OrderPlacedEvent){
        logger.info("started:$orderPlacedEvent")
        // Sleep was added so we have time to shut down app
        // thus illustrating when app starts how the event will be completed
        Thread.sleep(5_000)
        logger.info("stopped:$orderPlacedEvent")
    }
}