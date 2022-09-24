package com.example.itijuanatest.core.data.datasource

import com.example.itijuanatest.core.domain.models.Shipment

interface ShipmentsFileDataSource {
    suspend fun getAllShipments(): List<Shipment>?
}