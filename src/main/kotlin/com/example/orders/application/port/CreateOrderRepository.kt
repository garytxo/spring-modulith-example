package com.example.orders.application.port

import com.example.orders.domain.model.Order
import com.example.orders.domain.model.OrderId

fun interface CreateOrderRepository {

    fun create(order: Order): OrderId
}