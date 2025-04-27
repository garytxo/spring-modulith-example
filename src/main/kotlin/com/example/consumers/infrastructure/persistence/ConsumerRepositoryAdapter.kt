package com.example.consumers.infrastructure.persistence

import com.example.consumers.application.port.ConsumerRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ConsumerRepositoryAdapter:ConsumerRepository {

    override fun getCurrentUserId() = UUID.randomUUID()
}