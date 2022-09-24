package com.example.itijuanatest.data.driverLocal

import com.example.itijuanatest.core.data.datasource.DriversFileDataSource
import com.example.itijuanatest.core.domain.models.Driver

class DriversFileDataSourceImpl(
    private val rawDriverParser: ParserRawDriverData
) : DriversFileDataSource {
    override suspend fun getAllDrivers(): List<Driver>? {
        return rawDriverParser.getRawDriverData()?.toDomain() ?: run {
            null
        }
    }
}