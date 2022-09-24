package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepository
import com.example.itijuanatest.core.domain.StringUtils
import com.example.itijuanatest.core.domain.UtilsMath
import javax.inject.Inject

/*If the length of the shipment's destination street name is even, the base suitability score (SS)
is the number of vowels in the driver’s name multiplied by 1.5.

If the length of the shipment's destination street name is odd, the base SS is the number of consonants
in the driver’s name multiplied by1.

If the length of the shipment's destination street name shares any common factors (besides 1) with the length of the driver’s name, the
SS is increased by 50% above the base SS.*/

data class CalculateBestShipmentByDriver @Inject constructor(
    private val shipmentRepository: ShipmentRepository,
    private val driversRepository: DriversRepository,
    val math: UtilsMath,
    val stringUtils: StringUtils
) {

    suspend fun invoke() {
        val shipments = shipmentRepository.getAllShipments()
        val drivers = driversRepository.getAllDrivers()

        shipments.forEach { shipment ->
            val isEven = math.isEven(shipment.addressName.length)
            val map = mutableListOf<Pair<Double, Long>>()
            drivers.filter { it.isAvailable }.map { driver ->
                val score: Double = if (isEven) stringUtils.getVowelsCount(driver.name) * 1.5 else   stringUtils.getConsonants(driver.name) * 1.0
                map.add(Pair(score, driver.id))
            }
            map.sortWith(compareByDescending {
                it.first
            })
            map.firstOrNull()?.let { pair ->
                shipmentRepository.updateShipment(shipment, pair.second)
                drivers.find { it.id == pair.second }?.isAvailable = false
            }
        }
    }
}