package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.domain.models.Shipment

interface ShipmentsLocalDataSource {
    suspend fun getAllShipments(): Result<List<Shipment>>
}