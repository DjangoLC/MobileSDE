package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.Result
import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepository
import com.example.itijuanatest.core.domain.StringUtils
import com.example.itijuanatest.core.domain.UtilsMath
import javax.inject.Inject

/*If the length of the shipment's destination street name is even, the base suitability score (SS)
is the number of vowels in the driver’sname multiplied by 1.5.

If the length of the shipment's destination street name is odd, the base SS is the number of consonants
in the driver’s name multiplied by1.

If the length of the shipment's destination street name shares any common factors (besides 1) with the length of the driver’s name, the
SS is increased by 50% above the base SS.*/

data class CalculateBestShipmentByDriver @Inject constructor(
    private val shipmentRepository: ShipmentRepository,
    val math: UtilsMath,
    val stringUtils: StringUtils
) {

    suspend fun invoke(driverName: String): Result<String> {
        return when (val shipments = shipmentRepository.getAllShipments()) {
            is Result.Error -> {
                Result.Error(Throwable("there is a problem trying to calculate the better shipment to driver"))
            }
            is Result.Success -> {
                /*val evenShipmentsName =  shipments.data.filter { math.isEven(it.addressName.trim().length) }
                 val scores = evenShipmentsName.map {
                     it.copy(score = stringUtils.getVowelsCount(driverName) * 1.5)
                 }.sortedByDescending {
                     it.addressName
                 }
                 println(scores)*/
                Result.Success("")
            }
        }
    }
}