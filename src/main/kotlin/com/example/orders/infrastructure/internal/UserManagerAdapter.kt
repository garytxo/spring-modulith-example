package com.example.orders.infrastructure.internal

import com.example.consumers.infrastructure.ConsumerManagementApi
import com.example.orders.application.port.UserManager
import org.springframework.stereotype.Service
import java.util.UUID

@Service
internal class UserManagerAdapter(
    private val consumerManagementApi: ConsumerManagementApi
): UserManager {

    override fun getCurrentUserId(): UUID {
        return consumerManagementApi.getCurrentUserId()
    }
}