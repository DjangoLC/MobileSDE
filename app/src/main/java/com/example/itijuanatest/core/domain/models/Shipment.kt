package com.example.itijuanatest.core.domain.models

data class Shipment(
    val id: String,
    val addressName: String,
    var score: Double = 0.0
)