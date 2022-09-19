package com.example.itijuanatest.domain.usecases

import com.example.itijuanatest.data.repositories.driver.DriversRepository

data class GetAllDrivers(private val driversRepository: DriversRepository) {
    suspend operator fun invoke() = driversRepository.getAllDrivers()
}