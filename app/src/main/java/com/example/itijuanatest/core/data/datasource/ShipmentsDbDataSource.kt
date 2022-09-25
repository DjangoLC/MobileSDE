package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.domain.models.Shipment

interface ShipmentsDbDataSource {
    suspend fun insertShipments(shipments: List<Shipment>)
    suspend fun getAllShipments(): List<Shipment>
    suspend fun updateShipment(shipment: Shipment, driverId: Long)
    suspend fun isEmpty(): Boolean
}