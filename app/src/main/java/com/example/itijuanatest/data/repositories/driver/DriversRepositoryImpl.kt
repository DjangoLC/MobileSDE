package com.example.itijuanatest.data.repositories.driver

import com.example.itijuanatest.data.datasource.DriversLocalDataSource
import com.example.itijuanatest.domain.models.Driver

class DriversRepositoryImpl(private val localDataSource: DriversLocalDataSource) : DriversRepository {
    override suspend fun getAllDrivers(): Result<List<Driver>> {
        return localDataSource.getAllDrivers()
    }
}