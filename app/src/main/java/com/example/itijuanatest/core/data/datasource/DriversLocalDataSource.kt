package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.data.Result
import com.example.itijuanatest.core.domain.models.Driver

interface DriversLocalDataSource {
    suspend fun getAllDrivers() : Result<List<Driver>>
}