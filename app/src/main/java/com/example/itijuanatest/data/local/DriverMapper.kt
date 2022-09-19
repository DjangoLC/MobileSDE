package com.example.itijuanatest.data.local

import com.example.itijuanatest.core.domain.models.Driver
import java.util.*

fun RawDriver.toDomain() =
    this.drivers.map {
        Driver(id = UUID.randomUUID().toString(), it)
    }
