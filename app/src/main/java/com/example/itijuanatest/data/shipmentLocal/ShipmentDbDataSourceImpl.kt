package com.example.itijuanatest.data.shipmentLocal

import com.example.itijuanatest.core.data.datasource.ShipmentsDbDataSource
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.data.db.dao.ShipmentDao

class ShipmentDbDataSourceImpl(private val shipmentDao: ShipmentDao) : ShipmentsDbDataSource {
    override suspend fun insertShipments(shipments: List<Shipment>) {
        shipmentDao.insertShipments(shipments.map { it.toDb() })
    }

    override suspend fun getAllShipments(): List<Shipment> {
        return shipmentDao.getAllShipments().map { it.toDb() }
    }
}