package com.example.itijuanatest.ui.driverslist

import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.core.data.Result
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

    var _uiState = MutableLiveData<DriversListState>()
        private set

    fun getAllDrivers() {
        launch {
            _uiState.value = when (val call = getAllDrivers.invoke()) {
                is Result.Error -> {
                    DriversListState.Error(Exception())
                }
                is Result.Success -> {
                    DriversListState.Success(call.data)
                }
            }
        }
    }
}