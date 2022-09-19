package com.example.itijuanatest.ui.driverdetail

import com.example.itijuanatest.core.domain.models.Shipment

sealed class ShipmentListState {
    object Loading : ShipmentListState()
    class Success(data: List<Shipment>) : ShipmentListState()
    class Error(data: Exception) : ShipmentListState()
}