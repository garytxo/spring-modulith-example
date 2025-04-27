package com.example.orders.infrastructure.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Exchange
import org.springframework.amqp.core.ExchangeBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AmpqConfiguration {

    companion object {
        const val ORDERS_DESTINATION = "order"
    }

    @Bean
    fun binding(queue: Queue,exchange: Exchange) =
        BindingBuilder.bind(queue).to(exchange).with(ORDERS_DESTINATION).noargs()

    @Bean
    fun queue() = QueueBuilder.durable().build()

    @Bean
    fun exchange() :DirectExchange =
        ExchangeBuilder.directExchange(ORDERS_DESTINATION).durable(true).build()

}