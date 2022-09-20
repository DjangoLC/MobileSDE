package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.Result
import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import com.example.itijuanatest.core.domain.models.Driver
import javax.inject.Inject

data class GetAllDrivers @Inject constructor(private val driversRepository: DriversRepository) {
    suspend operator fun invoke(): Result<List<Driver>> = driversRepository.getAllDrivers()
}