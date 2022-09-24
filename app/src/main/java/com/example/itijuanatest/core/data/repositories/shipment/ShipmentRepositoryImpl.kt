package com.example.itijuanatest.core.data.repositories.shipment

import com.example.itijuanatest.core.data.datasource.ShipmentsFileDataSource
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.core.data.Result
import com.example.itijuanatest.core.data.datasource.ShipmentsDbDataSource

class ShipmentRepositoryImpl(
    private val fileShipmentDataSource: ShipmentsFileDataSource,
    private val shipmentsDbDataSource: ShipmentsDbDataSource
) : ShipmentRepository {
    override suspend fun getAllShipments(): List<Shipment> {
        val inFileShipment = fileShipmentDataSource.getAllShipments()
        inFileShipment?.let {
            shipmentsDbDataSource.insertShipments(inFileShipment)
        }
        return shipmentsDbDataSource.getAllShipments()
    }

    override suspend fun updateShipment(shipment: Shipment) {
        TODO("Not yet implemented")
    }
}