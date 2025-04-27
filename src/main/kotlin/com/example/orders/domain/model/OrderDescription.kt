package com.example.orders.domain.model

data class OrderDescription private constructor(val value:String){

    companion object {
        fun toDescription(value: String) = OrderDescription(value)

    }
}