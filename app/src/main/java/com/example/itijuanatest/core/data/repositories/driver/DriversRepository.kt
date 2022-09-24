package com.example.itijuanatest.core.data.repositories.driver

import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.core.domain.models.DriverAndShipment

interface DriversRepository {
    suspend fun getAllDrivers() : List<Driver>
    suspend fun getDriverWitShipment(driverId: Long): DriverAndShipment
}