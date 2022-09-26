package com.example.itijuanatest.ui.driverslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.core.domain.usecases.CalculateBestShipmentByDriver
import com.example.itijuanatest.core.domain.usecases.GetAllDrivers
import com.example.itijuanatest.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getAllDrivers: GetAllDrivers,
    private val calculateBestShipmentByDriver: CalculateBestShipmentByDriver,
    dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher) {

    private val _uiState = MutableLiveData<DriversListState>()
    val uiState: LiveData<DriversListState> = _uiState

    fun getAllDrivers() {
        launch {
            _uiState.value = DriversListState.Loading
            _uiState.value = DriversListState.Success(getAllDrivers.invoke())
            calculateBestShipmentByDriver.invoke()
        }
    }
}