package com.example.orders.application

import com.example.orders.domain.model.Order
import com.example.orders.domain.model.OrderBy
import com.example.orders.domain.model.OrderDescription
import com.example.orders.domain.model.OrderLineItem
import com.example.orders.application.port.CreateOrderRepository
import com.example.shared.application.CommandHandler
import com.example.shared.application.DomainEventDispatcher
import com.example.orders.application.port.UserManager
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
internal class CreateOrderCommandHandler(
    private val createOrderRepository: CreateOrderRepository,
    private val domainEventDispatcher: DomainEventDispatcher,
    private val userManager: UserManager
    ):CommandHandler<String,CreateOrderCommand> {
    override fun execute(command: CreateOrderCommand): String {

        val order = Order.create(
           orderBy = getCurrentUserId(),
            description = OrderDescription.toDescription(command.description),
            orderItems = command.lineItem.map { OrderLineItem.toOrderItem(it.quantity,it.productId) }
        )
        domainEventDispatcher.dispatch(order)
        return createOrderRepository.create(order).toString()
    }

    private fun getCurrentUserId() = OrderBy(
        consumerId = userManager.getCurrentUserId()
    )
}