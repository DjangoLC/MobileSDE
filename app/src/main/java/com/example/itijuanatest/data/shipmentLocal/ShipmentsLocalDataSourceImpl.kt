package com.example.itijuanatest.data.shipmentLocal

import com.example.itijuanatest.core.data.datasource.ShipmentsLocalDataSource
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.data.driverLocal.ParserRawDriverData
import com.example.itijuanatest.data.driverLocal.toDomain
import java.lang.Exception

class ShipmentsLocalDataSourceImpl(private val rawDriverParser: ParserRawShipmentData) : ShipmentsLocalDataSource {
    override suspend fun getAllShipments(): Result<List<Shipment>> {
        rawDriverParser.getRawShipmentData()?.let {
            return Result.success(it.toDomain())
        } ?: kotlin.run {
            return Result.failure(Exception("cant parse raw data"))
        }
    }
}