package com.example.itijuanatest.data.driverLocal

import com.example.itijuanatest.core.data.datasource.DriversDbDataSource
import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.data.db.dao.DriverDao
import kotlinx.coroutines.flow.map

class DriversDbDataSourceImpl(private val driverDao: DriverDao) : DriversDbDataSource {
    override suspend fun getAllDrivers(): List<Driver> {
        return driverDao.getAllDrivers().map{it.toDomain()}
    }

    override suspend fun insertDrivers(driversInFile: List<Driver>) {
        return driverDao.insertDriversList(driversInFile.map { it.toDb() })
    }

    override suspend fun isEmpty(): Boolean {
        return driverDao.driversCount() == 0
    }
}