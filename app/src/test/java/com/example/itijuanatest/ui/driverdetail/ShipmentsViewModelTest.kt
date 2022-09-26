package com.example.itijuanatest.ui.driverdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.core.domain.models.DriverAndShipment
import com.example.itijuanatest.core.domain.models.Shipment
import com.example.itijuanatest.core.domain.usecases.GetDriverWithShipment
import com.example.itijuanatest.getOrAwaitValueTest
import com.example.itijuanatest.ui.driverslist.DriversViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.TestRule
import strikt.api.expectThat
import strikt.assertions.isA

class ShipmentsViewModelTest {

    @RelaxedMockK
    private lateinit var getDriverWithShipment: GetDriverWithShipment

    private lateinit var dispatcher: CoroutineDispatcher

    private lateinit var viewModel: ShipmentsViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val driverId = 1L

    private val driverAndShipment = DriverAndShipment(
        Driver(id = 0, name = "", isAvailable = false),
        Shipment(id = 0, addressName = "")
    )

    @Before
    fun before() {
        MockKAnnotations.init(this)
        dispatcher = Dispatchers.Unconfined
        viewModel = ShipmentsViewModel(
            getDriverWithShipment,
            dispatcher
        )
    }

    @Test
    fun getDriver() {
        coEvery { getDriverWithShipment.invoke(driverId) } returns driverAndShipment

        viewModel.getDriver(driverId)

        coVerify {
            getDriverWithShipment.invoke(driverId)
        }

        expectThat(viewModel.uiState.getOrAwaitValueTest())
            .isA<ShipmentListState.Success>()
    }
}