package com.example.consumers.application.port

import java.util.UUID

fun interface ConsumerRepository {

    fun getCurrentUserId():UUID
}