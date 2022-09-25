package com.example.itijuanatest.core.domain.models

import com.example.itijuanatest.core.domain.isEven

data class Shipment(
    val id: Long,
    val addressName: String
) {
    fun isEven() = addressName.length.isEven()
}