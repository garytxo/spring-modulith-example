package com.example.orders.domain.event

import org.springframework.modulith.NamedInterface
import org.springframework.modulith.PackageInfo

/**
 * Code in other application modules is allowed to refer to classes under this package
 */
@PackageInfo
@NamedInterface(name = arrayOf("events"))
class PackageInfo