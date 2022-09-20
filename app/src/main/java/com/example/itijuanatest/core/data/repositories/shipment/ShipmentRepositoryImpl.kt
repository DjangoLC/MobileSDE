package com.example.itijuanatest.core.data.repositories.shipment

import com.example.itijuanatest.core.data.datasource.ShipmentsLocalDataSource
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.core.data.Result

class ShipmentRepositoryImpl(private val localShipmentDataSource: ShipmentsLocalDataSource) : ShipmentRepository {
    override suspend fun getAllShipments(): Result<List<Shipment>> {
       return localShipmentDataSource.getAllShipments()
    }
}