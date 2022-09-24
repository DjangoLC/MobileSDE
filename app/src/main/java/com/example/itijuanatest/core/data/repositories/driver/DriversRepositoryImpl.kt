package com.example.itijuanatest.core.data.repositories.driver

import com.example.itijuanatest.core.data.datasource.DriversDbDataSource
import com.example.itijuanatest.core.data.datasource.DriversFileDataSource
import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.data.db.dao.DriverDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DriversRepositoryImpl(
    private val driversFileDataSource: DriversFileDataSource,
    private val driversDbDataSource: DriversDbDataSource) : DriversRepository {

    override suspend fun getAllDrivers(): Flow<List<Driver>> {
        val driversInFile = driversFileDataSource.getAllDrivers()
        driversInFile?.isNotEmpty()?.let {
            driversDbDataSource.insertDrivers(driversInFile)
        }
        return driversDbDataSource.getAllDrivers()
    }
}