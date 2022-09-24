package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.core.domain.models.DriverAndShipment

interface DriversDbDataSource {
    suspend fun getAllDrivers() :List<Driver>
    suspend fun insertDrivers(driversInFile: List<Driver>)
    suspend fun isEmpty(): Boolean
    suspend fun getDriverWitShipment(driverId: Long): DriverAndShipment
}