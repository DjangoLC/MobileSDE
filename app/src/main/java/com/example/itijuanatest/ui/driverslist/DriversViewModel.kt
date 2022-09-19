package com.example.itijuanatest.ui.driverslist

import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.domain.usecases.GetAllDrivers
import com.example.itijuanatest.utils.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class DriversViewModel(
    private val getAllDrivers: GetAllDrivers,
    dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher) {

    private val _uiState = MutableLiveData<DriversListState>()

    fun getAllDrivers() {
        launch {
            getAllDrivers.invoke()
        }
    }
}