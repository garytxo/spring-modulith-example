package com.example.orders.domain.model

import com.example.shared.domain.model.ID
import java.util.UUID

class OrderId(id: UUID? = null) : ID(generate(id).id)