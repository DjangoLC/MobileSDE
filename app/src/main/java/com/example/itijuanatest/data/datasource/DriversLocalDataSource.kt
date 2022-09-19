package com.example.itijuanatest.data.datasource

import com.example.itijuanatest.domain.models.Driver

interface DriversLocalDataSource {
    suspend fun getAllDrivers() : Result<List<Driver>>
}