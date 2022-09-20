package com.example.itijuanatest.core.data.repositories.shipment

import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.core.data.Result

interface ShipmentRepository {
    suspend fun getAllShipments(): Result<List<Shipment>>
}