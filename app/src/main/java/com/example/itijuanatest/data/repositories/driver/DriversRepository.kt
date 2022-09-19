package com.example.itijuanatest.data.repositories.driver

import com.example.itijuanatest.domain.models.Driver

interface DriversRepository {
    suspend fun getAllDrivers() : Result<List<Driver>>
}