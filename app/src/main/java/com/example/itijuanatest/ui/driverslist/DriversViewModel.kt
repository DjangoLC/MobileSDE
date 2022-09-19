package com.example.itijuanatest.ui.driverslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.core.domain.usecases.GetAllDrivers
import com.example.itijuanatest.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getAllDrivers: GetAllDrivers,
    dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher) {

    private val _uiState = MutableLiveData<DriversListState>()

    fun getAllDrivers() {
        launch {
            Log.e("TAG", "getAllDrivers: ${getAllDrivers.invoke().getOrNull().toString()}")
        }
    }
}