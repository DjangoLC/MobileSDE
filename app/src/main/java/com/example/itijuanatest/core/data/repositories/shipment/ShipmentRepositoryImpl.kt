package com.example.itijuanatest.core.data.repositories.shipment

import com.example.itijuanatest.core.data.datasource.ShipmentsFileDataSource
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.core.data.datasource.ShipmentsDbDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShipmentRepositoryImpl(
    private val fileShipmentDataSource: ShipmentsFileDataSource,
    private val shipmentsDbDataSource: ShipmentsDbDataSource
) : ShipmentRepository {
    override suspend fun getAllShipments(): List<Shipment> {
        return withContext(Dispatchers.IO) {
            val inFileShipment = fileShipmentDataSource.getAllShipments()
            inFileShipment?.let {
                shipmentsDbDataSource.insertShipments(inFileShipment)
            }
            shipmentsDbDataSource.getAllShipments()
        }
    }

    override suspend fun updateShipment(shipment: Shipment, driverId: Long) {
        shipmentsDbDataSource.updateShipment(shipment, driverId)
    }
}