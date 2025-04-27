package com.example.orders.infrastructure.persistence

import com.example.orders.domain.model.Order
import com.example.orders.domain.model.OrderId
import com.example.orders.application.port.CreateOrderRepository
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
internal class OrderPersistenceAdapter(
    private val orderRepository: OrderEntityJpaRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
    ): CreateOrderRepository {
    private val logger = LoggerFactory.getLogger(OrderPersistenceAdapter::class.java)

    override fun create(order: Order): OrderId {
        logger.info("Saving new order")
        val orderEntity = order.toEntity()
        val saved = orderRepository.save(orderEntity)
        logger.info("Saved order:$saved")

        applicationEventPublisher.publishEvent(order.pullEvents())
        return order.orderId
    }


    private fun Order.toEntity() = OrderEntity(
        uuid = this.orderId.id,
        description = this.description.value,
        lineItems = this.orderItems.map {
            OrderLineItemEntity(
                uuid = it.id,
                quantity = it.quanity,
                product = it.productId,
                ordersId = this.orderId.id
            )
        }.toMutableSet()
    )

}