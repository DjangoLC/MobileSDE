package com.example.itijuanatest.ui.driverslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.itijuanatest.CommonDrivers
import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.core.domain.usecases.CalculateBestShipmentByDriver
import com.example.itijuanatest.core.domain.usecases.GetAllDrivers
import com.example.itijuanatest.getOrAwaitValueTest
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class DriversViewModelTest {

    @RelaxedMockK
    private lateinit var getAllDrivers: GetAllDrivers

    @RelaxedMockK
    private lateinit var calculateBestShipmentByDriver: CalculateBestShipmentByDriver

    private lateinit var dispatcher: CoroutineDispatcher

    private lateinit var viewModel: DriversViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        init(this)
        dispatcher = Dispatchers.Unconfined
        viewModel = DriversViewModel(
            getAllDrivers,
            calculateBestShipmentByDriver,
            dispatcher
        )
    }

    @Test
    fun getAllDriversReturnSuccess() {
        runBlocking {
            coEvery { getAllDrivers.invoke() } returns CommonDrivers.listOfDrivers

            viewModel.getAllDrivers()

            coVerify {
                getAllDrivers.invoke()
                calculateBestShipmentByDriver.invoke()
            }

            expectThat(viewModel.uiState.getOrAwaitValueTest())
                .isA<DriversListState.Success>()
                .get{
                    this.data
                }
                .isEqualTo(
                    CommonDrivers.listOfDrivers
                )
        }
    }
}