package com.example.itijuanatest.core.data.repositories.driver

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.itijuanatest.CommonDrivers
import com.example.itijuanatest.core.data.datasource.DriversDbDataSource
import com.example.itijuanatest.core.data.datasource.DriversFileDataSource
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.TestRule
import strikt.api.expectThat
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo
import strikt.assertions.isNotEmpty

class DriversRepositoryImplTest {

    @RelaxedMockK
    private lateinit var driversFileDataSource: DriversFileDataSource

    @RelaxedMockK
    private lateinit var driversDbDataSource: DriversDbDataSource

    @InjectMockKs
    private lateinit var driversRepository: DriversRepositoryImpl

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        init(this)
    }

    @Test
    fun getAllDriversResultSuccess() {
        runBlocking {

            coEvery { driversFileDataSource.getAllDrivers() } returns CommonDrivers.listOfDrivers
            coEvery { driversDbDataSource.isEmpty() } returns true
            coEvery { driversDbDataSource.insertDrivers(CommonDrivers.listOfDrivers) } returns Unit
            coEvery { driversDbDataSource.getAllDrivers() } returns CommonDrivers.listOfDrivers

            val result = driversRepository.getAllDrivers()

            coVerify {
                driversFileDataSource.getAllDrivers()
                driversDbDataSource.isEmpty()
                driversDbDataSource.insertDrivers(CommonDrivers.listOfDrivers)
                driversDbDataSource.getAllDrivers()
            }

            expectThat(result)
                .isEqualTo(CommonDrivers.listOfDrivers)
                .isNotEmpty()
        }
    }

    @Test
    fun getAllDriversResultFails() {
        runBlocking {

            coEvery { driversFileDataSource.getAllDrivers() } returns emptyList()
            coEvery { driversDbDataSource.isEmpty() } returns false
            coEvery { driversDbDataSource.insertDrivers(emptyList()) } returns Unit
            coEvery { driversDbDataSource.getAllDrivers() } returns emptyList()

            val result = driversRepository.getAllDrivers()

            coVerify(inverse = true) {
                driversDbDataSource.insertDrivers(emptyList())
            }

            expectThat(result)
                .isEqualTo(emptyList())
                .isEmpty()
        }
    }

    @Test
    fun getDriverWithShipment() {
    }
}