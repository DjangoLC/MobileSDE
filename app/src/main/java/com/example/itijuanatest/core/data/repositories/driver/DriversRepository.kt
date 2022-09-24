package com.example.itijuanatest.core.data.repositories.driver

import com.example.itijuanatest.core.domain.models.Driver

interface DriversRepository {
    suspend fun getAllDrivers() : List<Driver>
}