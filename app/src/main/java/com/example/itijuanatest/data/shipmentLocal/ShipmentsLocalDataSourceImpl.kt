package com.example.itijuanatest.data.shipmentLocal

import com.example.itijuanatest.core.data.datasource.ShipmentsFileDataSource
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.core.data.Result

class ShipmentsLocalDataSourceImpl(private val rawDriverParser: ParserRawShipmentData) : ShipmentsFileDataSource {
    override suspend fun getAllShipments(): List<Shipment>? {
       return rawDriverParser.getRawShipmentData()?.toDomain() ?: kotlin.run {
             null
        }
    }
}