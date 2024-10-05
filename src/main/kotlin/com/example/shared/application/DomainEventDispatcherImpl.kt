package com.example.shared.application

import com.example.shared.domain.model.AggregateRoot
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
internal class DomainEventDispatcherImpl(
    private val applicationEventPublisher: ApplicationEventPublisher
) : DomainEventDispatcher {
    private val logger = LoggerFactory.getLogger(DomainEventDispatcherImpl::class.java)

    override fun dispatch(aggregateRoot: AggregateRoot<*>) {
       aggregateRoot.pullEvents().forEach {
           logger.info("Dispatching event:$it")
           applicationEventPublisher.publishEvent(it)
       }
    }
}