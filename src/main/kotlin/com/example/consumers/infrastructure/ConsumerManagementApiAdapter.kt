package com.example.consumers.infrastructure

import com.example.consumers.application.GetActiveConsumerQuery
import com.example.shared.application.QueryBus
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class ConsumerManagementApiAdapter(
   private val queryBus: QueryBus
) : ConsumerManagementApi {

   override fun getCurrentUserId() :UUID {
      val currentUserId = queryBus.dispatch(GetActiveConsumerQuery())
      return currentUserId
   }
}