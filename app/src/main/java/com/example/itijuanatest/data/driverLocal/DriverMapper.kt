package com.example.itijuanatest.data.driverLocal


import com.example.itijuanatest.data.shipmentLocal.toDomain
import com.example.itijuanatest.core.domain.models.DriverAndShipment as DriverAndShipmentDomain
import com.example.itijuanatest.data.db.DriverAndShipment as DriverAndShipmentDb
import com.example.itijuanatest.core.domain.models.Driver as DriverDomain
import com.example.itijuanatest.data.db.Driver as DriverDb

fun RawDriver.toDomain() =
    this.drivers.map {
        DriverDomain(0, it)
    }

fun DriverDomain.toDb() = DriverDb(id = this.id, name = this.name)

fun DriverDb.toDomain() = DriverDomain(id = this.id, name = this.name)

fun DriverAndShipmentDb.toDomain() = DriverAndShipmentDomain(driver = this.driver.toDomain(), shipment = shipment.toDomain())
