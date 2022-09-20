package com.example.itijuanatest.data.shipmentLocal

import com.example.itijuanatest.core.data.datasource.ShipmentsLocalDataSource
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.core.data.Result

class ShipmentsLocalDataSourceImpl(private val rawDriverParser: ParserRawShipmentData) : ShipmentsLocalDataSource {
    override suspend fun getAllShipments(): Result<List<Shipment>> {
        rawDriverParser.getRawShipmentData()?.let {
            return Result.Success(it.toDomain())
        } ?: kotlin.run {
            return Result.Error(Exception("cant parse raw data"))
        }
    }
}