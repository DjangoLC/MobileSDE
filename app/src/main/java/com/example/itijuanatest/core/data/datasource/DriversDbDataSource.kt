package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.domain.models.Driver
import kotlinx.coroutines.flow.Flow

interface DriversDbDataSource {
    suspend fun getAllDrivers() : Flow<List<Driver>>
    suspend fun insertDrivers(driversInFile: List<Driver>)
}