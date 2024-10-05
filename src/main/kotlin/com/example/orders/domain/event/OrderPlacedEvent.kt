package com.example.orders.domain.event


import com.example.shared.domain.event.DomainEvent

/**
 * Modulith  annotation @Externalized  simplfy pushing domain event
 * to external message broker
 */
//@Externalized(target = AmpqConfiguration.ORDERS_DESTINATION)
data class OrderPlacedEvent(
    val orderBy:String,
    val orderId:String
):DomainEvent,org.jmolecules.event.types.DomainEvent