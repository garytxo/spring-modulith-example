package com.example.orders

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.PackageInfo

@PackageInfo
@ApplicationModule(
    allowedDependencies = arrayOf("consumers::api"),)
class PackageInfo {
}