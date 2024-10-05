package com.example.orders.infrastructure.persistence


import com.example.shared.infrastructure.persistence.AuditableEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "orders_line_items")
internal data class OrderLineItemEntity(
    @Id
    @Column(name = "id")
    val uuid:UUID,

    @Column(name = "product")
    var product:Int,

    @Column(name = "quantity")
    var quantity:Int,

    @Column(name="orders_id", nullable=false)
    var ordersId:UUID

): AuditableEntity<UUID>() {

    override fun getId() = uuid
}
