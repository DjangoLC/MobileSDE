package com.example.itijuanatest.core.data.repositories.driver

import com.example.itijuanatest.core.domain.models.Driver
import kotlinx.coroutines.flow.Flow

interface DriversRepository {
    suspend fun getAllDrivers() : Flow<List<Driver>>
}