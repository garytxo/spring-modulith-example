package com.example.shared.domain.model


import java.util.UUID

abstract class ID(val id:UUID) {

    override fun toString(): String {
        return id.toString()
    }

    fun toUUID(): UUID {
        return id
    }
    companion object {

       fun generate(id: UUID? = null): ID {
           return object : ID(id ?: UUID.randomUUID()) {}
       }

    }
}
