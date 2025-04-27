package com.example.shared.application

fun interface QueryHandler<R, Q : Query<R>> {

    fun handle(query: Q): R
}