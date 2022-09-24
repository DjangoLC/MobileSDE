package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import com.example.itijuanatest.core.domain.models.DriverAndShipment
import javax.inject.Inject

class GetDriverWithShipment @Inject constructor(private val driversRepository: DriversRepository){
    suspend fun invoke(driverId: Long): DriverAndShipment {
        return driversRepository.getDriverWitShipment(driverId)
    }
}