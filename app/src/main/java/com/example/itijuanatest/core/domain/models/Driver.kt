package com.example.itijuanatest.core.domain.models

data class Driver(
    val id: Long,
    val name: String,
    var isAvailable: Boolean = true
)