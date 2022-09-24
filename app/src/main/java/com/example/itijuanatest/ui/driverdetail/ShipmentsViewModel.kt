package com.example.itijuanatest.ui.driverdetail

import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.core.domain.usecases.CalculateBestShipmentByDriver
import com.example.itijuanatest.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipmentsViewModel @Inject constructor(
    private val calculateBestShipmentByDriver: CalculateBestShipmentByDriver,
    dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher) {

    private val _uiState = MutableLiveData<ShipmentListState>()

    fun calculateShipment(driverName: String) {
        launch {
            val shipments = calculateBestShipmentByDriver.invoke(driverName)

        }
    }
}