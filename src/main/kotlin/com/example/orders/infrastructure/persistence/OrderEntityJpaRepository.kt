package com.example.orders.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

internal interface OrderEntityJpaRepository: JpaRepository<OrderEntity, UUID> {
}