package com.example.itijuanatest.ui.driverdetail

import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.core.domain.usecases.CalculateBestShipmentByDriver
import com.example.itijuanatest.core.domain.usecases.GetDriverWithShipment
import com.example.itijuanatest.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipmentsViewModel @Inject constructor(
    private val getDriverWithShipment: GetDriverWithShipment,
    dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher) {

    var _uiState = MutableLiveData<ShipmentListState>()
        private set

    fun getDriver(driverId: Long) {
        launch {
            _uiState.value = ShipmentListState.Success(getDriverWithShipment.invoke(driverId))
        }
    }
}