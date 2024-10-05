package com.example.shared.domain.model

import com.example.shared.domain.event.DomainEvent
import java.time.Instant

abstract class AggregateRoot<ID: com.example.shared.domain.model.ID> {

    private var domainEvents: MutableList<DomainEvent> = mutableListOf()
    private val createdAt = Instant.now()
    private var updatedAt = Instant.now()

    internal fun recordEvent(domainEvent: DomainEvent){
        domainEvents.add(domainEvent)
    }

    //TODO: clean out list after events are pulled
    internal fun pullEvents() = domainEvents.toList()
    /*
    protected fun recordEvent(domainEvent: DomainEvent<*>) {
        if (domainEvents == null) {
            domainEvents = ArrayList()
        }
        domainEvents!!.add(domainEvent)
        updateIt()
    }

    fun pullEvents(): List<DomainEvent<*>> {
        val domainEventsRecorded = domainEvents
        domainEvents = null
        return Collections.unmodifiableList(domainEventsRecorded ?: listOf())
    }
    */

    fun createdAt(): Instant {
        return createdAt
    }

    fun updatedAt(): Instant {
        return updatedAt
    }

    fun id() = ID

}