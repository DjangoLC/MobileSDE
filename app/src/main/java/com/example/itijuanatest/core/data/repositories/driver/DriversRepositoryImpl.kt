package com.example.itijuanatest.core.data.repositories.driver

import com.example.itijuanatest.core.data.datasource.DriversDbDataSource
import com.example.itijuanatest.core.data.datasource.DriversFileDataSource
import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.core.domain.models.DriverAndShipment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DriversRepositoryImpl(
    private val driversFileDataSource: DriversFileDataSource,
    private val driversDbDataSource: DriversDbDataSource
) : DriversRepository {

    override suspend fun getAllDrivers(): List<Driver> {
        return withContext(Dispatchers.IO) {
            val driversInFile = driversFileDataSource.getAllDrivers()
            val shouldInsert = (driversInFile?.isNotEmpty() == true && driversDbDataSource.isEmpty())
            if (shouldInsert) {
                driversInFile?.let { driversDbDataSource.insertDrivers(driversInFile) }
            }
            driversDbDataSource.getAllDrivers()
        }
    }

    override suspend fun getDriverWithShipment(driverId: Long): DriverAndShipment {
        return driversDbDataSource.getDriverWitShipment(driverId)
    }
}