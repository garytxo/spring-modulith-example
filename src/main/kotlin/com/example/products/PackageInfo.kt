package com.example.products

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.PackageInfo

@PackageInfo
@ApplicationModule(
    allowedDependencies = arrayOf("orders::events")
)
class PackageInfo {
}