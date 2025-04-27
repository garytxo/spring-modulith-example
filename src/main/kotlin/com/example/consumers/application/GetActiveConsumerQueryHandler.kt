package com.example.consumers.application

import com.example.consumers.application.port.ConsumerRepository
import com.example.shared.application.QueryHandler
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
@Transactional
internal class GetActiveConsumerQueryHandler(
    private val consumerRepository: ConsumerRepository
):QueryHandler<UUID,GetActiveConsumerQuery> {

    override fun handle(query: GetActiveConsumerQuery): UUID {
        return consumerRepository.getCurrentUserId()
    }
}