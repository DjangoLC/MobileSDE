package com.example.itijuanatest.ui.driverslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.core.domain.usecases.GetAllDrivers
import com.example.itijuanatest.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.itijuanatest.core.data.Result

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getAllDrivers: GetAllDrivers,
    dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher) {

    var _uiState = MutableLiveData<DriversListState>()
        private set

    fun getAllDrivers() {
        launch {
            _uiState.value = when (val call = getAllDrivers.invoke()) {
                is Result.Error -> {
                    Log.e("TAG", "getAllDrivers: ${call.exception.toString()}" )
                    DriversListState.Error(Exception())
                }
                is Result.Success -> {
                    Log.e("TAG", "getAllDrivers: ${call.data.toString()}" )
                    DriversListState.Success(call.data)
                }
            }
        }
    }
}