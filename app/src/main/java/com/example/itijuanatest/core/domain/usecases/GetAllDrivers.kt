package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import javax.inject.Inject

data class GetAllDrivers @Inject constructor(private val driversRepository: DriversRepository) {
    suspend operator fun invoke() = driversRepository.getAllDrivers()
}