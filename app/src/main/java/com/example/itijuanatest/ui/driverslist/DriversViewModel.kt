package com.example.itijuanatest.ui.driverslist

import androidx.lifecycle.MutableLiveData
import com.example.itijuanatest.core.domain.usecases.GetAllDrivers
import com.example.itijuanatest.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
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
            _uiState.value = DriversListState.Loading
            getAllDrivers.invoke()
                .catch {
                    _uiState.value =
                        DriversListState.Error(Exception("an error occurs trying to collect drivers"))
                }
                .collect {
                    _uiState.value = DriversListState.Success(it)
                }
        }
    }
}