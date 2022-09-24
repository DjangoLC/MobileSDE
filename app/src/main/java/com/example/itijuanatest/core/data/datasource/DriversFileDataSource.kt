package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.domain.models.Driver

interface DriversFileDataSource {
    suspend fun getAllDrivers() : List<Driver>?
}