package com.example.orders.infrastructure.rest

import com.example.orders.application.CreateOrderCommand
import com.example.orders.application.LineItem
import com.example.shared.application.CommandBus
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
@RequestMapping("orders")
internal class CreateOrderController (val commandBus: CommandBus) {

    private val logger = LoggerFactory.getLogger(CreateOrderController::class.java)

    @PostMapping
    fun place(
        @RequestBody orderRequest: CreateOrderRequest
    ){
        logger.info("Creating order:$orderRequest")
        val command = orderRequest.toCommand()
        val response = commandBus.dispatch(command)

        logger.info("Created order:$response")


    }

    private fun CreateOrderRequest.toCommand() = CreateOrderCommand(
        description = this.description,
        lineItem = this.lineItems.map {
            LineItem(it.quantity,
                it.product) },
    )
}


