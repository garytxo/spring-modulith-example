package com.example.orders.domain.model

import com.example.orders.domain.event.OrderPlacedEvent
import com.example.shared.domain.model.AggregateRoot

class Order private constructor(
    val orderId: OrderId,
    val orderBy: OrderBy,
    val description:OrderDescription,
    val orderItems:List<OrderLineItem>
): AggregateRoot<OrderId>() {

    companion object {

        fun create(
            orderBy: OrderBy,
            description: OrderDescription,
            orderItems: List<OrderLineItem>) :Order{

            return Order(
                orderId = OrderId(null),
                orderBy = orderBy,
                description= description,
                orderItems = orderItems
            ).also {
                it.recordEvent(
                    OrderPlacedEvent(
                      orderBy = it.orderBy.consumerId.toString(),
                      orderId = it.orderId.id.toString()
                    )
                )
            }

        }


    }

}