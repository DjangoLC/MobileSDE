package com.example.itijuanatest.ui.driverslist

import com.example.itijuanatest.domain.models.Driver

sealed class DriversListState {
    object Loading : DriversListState()
    class Success(data: List<Driver>) : DriversListState()
    class Error(data: Exception) : DriversListState()
}