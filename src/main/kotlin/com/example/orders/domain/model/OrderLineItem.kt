package com.example.orders.domain.model

import java.util.UUID

data class OrderLineItem private constructor(
    val id:UUID,
    val quanity:Int,
    val productId:Int
){

    companion object {
        fun toOrderItem(quanity: Int, productId: Int) =
            OrderLineItem(
                id = UUID.randomUUID(),
                quanity = quanity,
                productId = productId
            )
    }
}