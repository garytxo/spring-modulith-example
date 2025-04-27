package com.example.consumers.infrastructure

import java.util.UUID

fun interface ConsumerManagementApi {

    fun getCurrentUserId() : UUID
}