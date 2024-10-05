package com.example.shared.application

fun interface CommandHandler<R,C:Command<R>> {

    fun execute(command: C): R
}