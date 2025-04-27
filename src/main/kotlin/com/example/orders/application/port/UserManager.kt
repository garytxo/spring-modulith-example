package com.example.orders.application.port

import java.util.UUID

fun interface UserManager {
    fun getCurrentUserId() : UUID
}