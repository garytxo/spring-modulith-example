package com.example.shared.application

import com.example.shared.domain.model.AggregateRoot

fun interface DomainEventDispatcher {

    fun dispatch(aggregateRoot: AggregateRoot<*>)
}