package com.example.itijuanatest.data.db.dao

import androidx.room.*
import com.example.itijuanatest.data.db.Shipment

@Dao
interface ShipmentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertShipments(shipments: List<Shipment>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertShipment(shipment: Shipment)

    @Update
    suspend fun updateShipment(shipment: Shipment)

    @Query("SELECT * FROM ${Shipment.TABLE_NAME}")
    suspend fun getAllShipments(): List<Shipment>

    @Query("SELECT COUNT(id) FROM ${Shipment.TABLE_NAME}")
    suspend fun isEmpty(): Int
}