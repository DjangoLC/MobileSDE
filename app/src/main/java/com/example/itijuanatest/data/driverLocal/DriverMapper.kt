package com.example.itijuanatest.data.driverLocal

import com.example.itijuanatest.core.domain.models.Driver as DriverDomain
import com.example.itijuanatest.data.db.Driver as DriverDb

fun RawDriver.toDomain() =
    this.drivers.map {
        DriverDomain(0, it)
    }

fun DriverDomain.toDb() = DriverDb(name = this.name)

fun DriverDb.toDomain() = DriverDomain(id = this.id, name = this.name)
