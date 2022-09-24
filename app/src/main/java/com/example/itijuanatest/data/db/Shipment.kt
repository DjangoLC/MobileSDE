package com.example.itijuanatest.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Shipment(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val addressName: String,
    val driverId: Long
) {
    companion object {
        const val TABLE_NAME = "Shipment"
    }
}