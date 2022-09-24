package com.example.itijuanatest.core.data.repositories.shipment

import com.example.itijuanatest.core.domain.models.Shipment

interface ShipmentRepository {
    suspend fun getAllShipments(): List<Shipment>
    suspend fun updateShipment(shipment: Shipment, driverId: Long)
}