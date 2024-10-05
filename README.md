# Spring Modulith Playground

## What is Spring Modulith

Spring Modulith is a none intrusive library to help improve the architecture 
of spring applications by dividing subpackage into distinct modules.
This each module thus encapsulates its own logic, dependencies,
and configuration, this promoting separation of concerns and improving maintainability.

This small Inventory Application illustrates how we can take Spring Modulith and add it to 
some legacy project where currently use hexagonal architecture (with CQRS) and DDD

## Inventory Application Modules 
The Inventory  project is a simple inventory application to manage orders of product.

## TODO 
- Explain how the PackageInfo are used to expose internal api and events
- Check if we can override the domain events database schema
- 



## Working with example
- Sample CURL to start order
```
  curl --request POST \
  --url http://127.0.0.1:8080/orders \
  --header 'Content-Type: application/json' \
  --header 'accept: application/json' \
  --data '{  "description": "test", "lineItems": [{ "quantity":4,"product": 5}]}'
```
- Externalized message broker  RambitMQ admin http://127.0.0.1:15672/ (myuser,secret)


## Implementation new module 
The idea is that we should declare all classes in the new module as  Package-Private / Default Visibility.
In Java “package-private” (also referred to as “default”) which means 
that any code in the same package can access it, 
but any code in a different package can not, including subclasses.
Unfortunately kotlin does not currently support this modifer as explained [here](https://www.baeldung.com/kotlin/visibility-modifiers#4-package-private--default-visibility) 
But maybe it is possible with the [internal modifer](https://www.baeldung.com/kotlin/visibility-modifiers#5-internal-visibility) 


## Ideas to take into consider 

- [Spring Tips](https://github.com/spring-tips/spring-modulith/) 
  - Nice example looking under the hood of modulith
- [Open Module](https://docs.spring.io/spring-modulith/reference/1.3-SNAPSHOT/fundamentals.html#modules.advanced.open )
  - Would be very useful when trying to migrate to modulith 
- [Application Events](https://docs.spring.io/spring-modulith/reference/1.3-SNAPSHOT/events.html) 
  - modulith uses the outbox pattern to ensure that the events a fired (persisted to the database and time stamped when completed)
  - need to check if the modulith events table can be extended and renamed (or vice versa)
- [Spring Events](https://medium.com/hprog99/mastering-events-in-spring-boot-a-comprehensive-guide-86348f968fc6)
- [Transactional Outbox pattern with Spring Boot](https://www.wimdeblauwe.com/blog/2024/06/25/transactional-outbox-pattern-with-spring-boot/) good read on how to implement our own outbox pattern and using modulith
- [Event Sourcing with Spring Modulith](https://medium.com/andamp/event-sourcing-with-spring-modulith-2b35b0569dbb)
- [Extend the events table issue](https://github.com/spring-projects/spring-modulith/issues/417)

https://www.javaguides.net/2024/05/spring-modulith-tutorial.html 
