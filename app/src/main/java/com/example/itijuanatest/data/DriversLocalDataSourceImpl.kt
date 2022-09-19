package com.example.itijuanatest.data

import com.example.itijuanatest.core.data.datasource.DriversLocalDataSource
import com.example.itijuanatest.core.domain.models.Driver

class DriversLocalDataSourceImpl : DriversLocalDataSource {
    override suspend fun getAllDrivers(): Result<List<Driver>> {
        return Result.success(emptyList())
    }
}