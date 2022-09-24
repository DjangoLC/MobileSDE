package com.example.itijuanatest.ui.driverdetail

import com.example.itijuanatest.core.domain.models.DriverAndShipment

sealed class ShipmentListState {
    object Loading : ShipmentListState()
    class Success(val data: DriverAndShipment) : ShipmentListState()
    class Error(val data: Exception) : ShipmentListState()
}