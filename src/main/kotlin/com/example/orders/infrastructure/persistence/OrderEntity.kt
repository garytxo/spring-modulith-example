package com.example.orders.infrastructure.persistence

import com.example.shared.infrastructure.persistence.AuditableEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "orders")
internal data class OrderEntity (
    @Id
    @Column(name = "id")
    val uuid:UUID,

    @Column(name = "description")
    var description: String,

    @OneToMany(mappedBy = "ordersId", fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    var lineItems : MutableSet<OrderLineItemEntity> = mutableSetOf()
): AuditableEntity<UUID>() {

    override fun getId() = uuid
}
