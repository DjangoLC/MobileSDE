package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepository
import com.example.itijuanatest.core.domain.commonsFactorOf
import com.example.itijuanatest.core.domain.getConsonants
import com.example.itijuanatest.core.domain.getVowelsCount
import com.example.itijuanatest.core.domain.isEven
import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.core.domain.models.Shipment
import javax.inject.Inject

/*If the length of the shipment's destination street name is even, the base suitability score (SS)
is the number of vowels in the driver’s name multiplied by 1.5.

If the length of the shipment's destination street name is odd, the base SS is the number of consonants
in the driver’s name multiplied by1.

If the length of the shipment's destination street name shares any common factors (besides 1) with the length of the driver’s name, the
SS is increased by 50% above the base SS.*/

data class CalculateBestShipmentByDriver @Inject constructor(
    private val shipmentRepository: ShipmentRepository,
    private val driversRepository: DriversRepository
) {

    suspend fun invoke() {
        val shipments = shipmentRepository.getAllShipments()
        val drivers = driversRepository.getAllDrivers()
        val map = mutableMapOf<Shipment, Pair<Double, Driver>>()
        val sortDrivers = drivers.sortedByDescending {
            it.name.length
        }
        val sortEvenDrivers = sortDrivers.sortedByDescending {
            it.getMaxScore(true)
        }
        val sortOddDrivers = sortDrivers.sortedByDescending {
            it.getMaxScore(false)
        }

        shipments.sortedByDescending {
            it.addressName.length
        }.forEach { shipment ->
            val isEven = shipment.isEven()
            val validDrivers = if (isEven) sortEvenDrivers else sortOddDrivers
            val maxDriver = validDrivers.first { it.isAvailable }
            var score = maxDriver.getMaxScore(isEven)
            if (
                hasMoreThanOneCommonFactor(
                    shipment.addressName.trim().commonsFactorOf(),
                    maxDriver.name.trim().commonsFactorOf()
                )
            ) {
                score = maxDriver.getMaxScore(isEven) * 1.5
            }
            map[shipment] = Pair(score, maxDriver)
            sortEvenDrivers.find { it.id == maxDriver.id }?.isAvailable = false
            sortOddDrivers.find { it.id == maxDriver.id }?.isAvailable = false
            shipmentRepository.updateShipment(shipment, maxDriver.id)
        }
    }

    private fun hasMoreThanOneCommonFactor(list: List<Int>, list2: List<Int>): Boolean {
        val result = list.intersect(list2)
        return (result.size > 1 && result.contains(1))
    }
}