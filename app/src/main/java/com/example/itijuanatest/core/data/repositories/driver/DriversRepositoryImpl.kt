package com.example.itijuanatest.core.data.repositories.driver

import com.example.itijuanatest.core.data.datasource.DriversLocalDataSource
import com.example.itijuanatest.core.domain.models.Driver

class DriversRepositoryImpl(private val localDataSource: DriversLocalDataSource) : DriversRepository {
    override suspend fun getAllDrivers(): Result<List<Driver>> {
        return localDataSource.getAllDrivers()
    }
}