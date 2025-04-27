package com.example.orders.application

import com.example.shared.application.Command

data class CreateOrderCommand(
    val description: String,
    val lineItem: List<LineItem>
) : Command<String>

data class LineItem( val quantity:Int,
                     val productId:Int)