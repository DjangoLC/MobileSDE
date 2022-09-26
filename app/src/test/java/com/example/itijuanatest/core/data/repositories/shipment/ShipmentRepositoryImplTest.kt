package com.example.itijuanatest.core.data.repositories.shipment

import com.example.itijuanatest.CommonShipments
import com.example.itijuanatest.core.data.datasource.ShipmentsDbDataSource
import com.example.itijuanatest.core.data.datasource.ShipmentsFileDataSource
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo
import strikt.assertions.isNotEmpty

class ShipmentRepositoryImplTest {

    @RelaxedMockK
    private lateinit var fileShipmentDataSource: ShipmentsFileDataSource

    @RelaxedMockK
    private lateinit var shipmentsDbDataSource: ShipmentsDbDataSource

    @InjectMockKs
    private lateinit var shipmentRepository: ShipmentRepositoryImpl

    private val driverId = 1L

    @Before
    fun setup() {
        init(this)
    }

    @Test
    fun getAllShipmentsReturnSuccess() {
        runBlocking {

            coEvery { fileShipmentDataSource.getAllShipments() } returns CommonShipments.shipments
            coEvery { shipmentsDbDataSource.isEmpty() } returns true
            coEvery { shipmentsDbDataSource.insertShipments(CommonShipments.shipments) } returns Unit
            coEvery { shipmentsDbDataSource.getAllShipments() } returns CommonShipments.shipments

            val result = shipmentRepository.getAllShipments()

            coVerify(exactly = 1) {
                fileShipmentDataSource.getAllShipments()
                shipmentsDbDataSource.isEmpty()
                shipmentsDbDataSource.insertShipments(any())
                shipmentsDbDataSource.getAllShipments()
            }

            expectThat(result)
                .isNotEmpty()
                .isEqualTo(CommonShipments.shipments)
        }
    }

    @Test
    fun getAllShipmentsReturnFails() {
        runBlocking {

            coEvery { fileShipmentDataSource.getAllShipments() } returns emptyList()
            coEvery { shipmentsDbDataSource.isEmpty() } returns false

            val result = shipmentRepository.getAllShipments()

            coVerify(inverse = true) {
                shipmentsDbDataSource.insertShipments(any())
            }

            expectThat(result)
                .isEmpty()
        }
    }

    @Test
    fun updateShipmentReturnsSuccess() {
        runBlocking {

            coEvery { shipmentsDbDataSource.updateShipment(CommonShipments.shipment, driverId) } returns Unit

            shipmentsDbDataSource.updateShipment(CommonShipments.shipment, driverId)

            coVerify {
                shipmentsDbDataSource.updateShipment(CommonShipments.shipment, driverId)
            }
        }
    }
}