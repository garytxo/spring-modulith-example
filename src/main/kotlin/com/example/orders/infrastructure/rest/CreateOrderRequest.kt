package com.example.orders.infrastructure.rest

data class CreateOrderRequest(
    val description:String,
    val lineItems:List<LineItemRequest>
)

data class LineItemRequest(
    val quantity:Int,
    val product:Int)