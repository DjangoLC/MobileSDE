package com.example.itijuanatest.data.driverLocal

import com.example.itijuanatest.core.data.datasource.DriversLocalDataSource
import com.example.itijuanatest.core.domain.models.Driver
import java.lang.Exception
import com.example.itijuanatest.core.data.Result

class DriversLocalDataSourceImpl(private val rawDriverParser: ParserRawDriverData) :
    DriversLocalDataSource {
    override suspend fun getAllDrivers(): Result<List<Driver>> {
        rawDriverParser.getRawDriverData()?.let {
            return Result.Success(it.toDomain())
        } ?: kotlin.run {
            return Result.Error(Exception("cant parse raw data"))
        }
    }
}