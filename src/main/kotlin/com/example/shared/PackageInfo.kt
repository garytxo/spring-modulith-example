package com.example.shared

import org.springframework.modulith.ApplicationModule

/**
 *
 * This feature is intended to be primarily used with code bases of existing projects gradually moving to the Spring Modulith recommended packaging structure.
 * In a fully-modularized application, using open application modules usually hints at sub-optimal modularization and packaging structures.
 * https://docs.spring.io/spring-modulith/reference/fundamentals.html#modules.advanced.open
 */
@ApplicationModule(
    type = ApplicationModule.Type.OPEN
)
class PackageInfo {
}