package com.example.itijuanatest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.itijuanatest.data.db.Shipment

@Dao
interface ShipmentDao {

    @Insert
    suspend fun insertShipment(shipment: Shipment)

    @Update
    suspend fun updateShipment(shipment: Shipment)
}