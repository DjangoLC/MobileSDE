package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepository
import javax.inject.Inject

data class GetShipments @Inject constructor(private val shipmentRepository: ShipmentRepository) {
    suspend operator fun invoke() = shipmentRepository.getAllShipments()
}