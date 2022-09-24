package com.example.itijuanatest.data.db

import androidx.room.Embedded
import androidx.room.Relation

class DriverAndLibrary(
    @Embedded val driver: Driver,
    @Relation(
        parentColumn = "id",
        entityColumn = "driverId"
    ) val shipment: Shipment
)