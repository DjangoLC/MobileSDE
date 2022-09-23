package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.Result
import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepository
import com.example.itijuanatest.core.domain.StringUtils
import com.example.itijuanatest.core.domain.UtilsMath
import javax.inject.Inject

data class GetShipments @Inject constructor(private val shipmentRepository: ShipmentRepository, val math: UtilsMath, val stringUtils: StringUtils) {

    private suspend fun invoke() = shipmentRepository.getAllShipments()

    suspend fun calculateBetterShipment(driverName: String): String {
        val shipments = invoke()
        when (shipments) {
            is Result.Error -> {

            }
            is Result.Success -> {
                val evenShipmentsName =  shipments.data.filter { math.isEven(it.addressName.trim().length) }
                val scores = evenShipmentsName.map {
                    it.copy(score = stringUtils.getVowelsCount(driverName) * 1.5)
                }.sortedByDescending {
                    it.addressName
                }
                println(scores)
            }
        }
        return ""
    }


}