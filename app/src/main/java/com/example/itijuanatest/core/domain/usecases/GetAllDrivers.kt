package com.example.itijuanatest.core.domain.usecases

import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import com.example.itijuanatest.core.domain.models.Driver
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class GetAllDrivers @Inject constructor(private val driversRepository: DriversRepository) {
    suspend operator fun invoke(): Flow<List<Driver>> = driversRepository.getAllDrivers()
}