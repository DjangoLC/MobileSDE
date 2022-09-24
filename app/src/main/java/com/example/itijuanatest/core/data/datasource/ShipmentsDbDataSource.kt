package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.domain.models.Shipment

interface ShipmentsDbDataSource {
    suspend fun insertShipments(shipments: List<Shipment>)
    suspend fun getAllShipments(): List<Shipment>
}