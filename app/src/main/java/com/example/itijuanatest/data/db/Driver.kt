package com.example.itijuanatest.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Driver(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String
) {
    companion object {
        const val TABLE_NAME = "Driver"
    }
}