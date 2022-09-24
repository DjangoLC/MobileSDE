package com.example.itijuanatest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.itijuanatest.data.db.Driver
import com.example.itijuanatest.data.db.DriverAndShipment

@Dao
interface DriverDao {
    @Transaction
    @Query("SELECT * FROM ${Driver.TABLE_NAME} WHERE ${Driver.TABLE_NAME}.id = :driverId")
    suspend fun getDriverAndShipment(driverId: Long): DriverAndShipment

    @Transaction
    @Query("SELECT * FROM ${Driver.TABLE_NAME}")
    suspend fun getAllDriversAndAddress(): List<DriverAndShipment>

    @Insert
    suspend fun insertDriver(driver: Driver)

    @Insert
    suspend fun insertDriversList(drivers: List<Driver>)

    @Query("SELECT * FROM ${Driver.TABLE_NAME}")
    fun getAllDrivers(): List<Driver>

    @Query("SELECT COUNT(id) FROM ${Driver.TABLE_NAME}")
    suspend fun driversCount(): Int
}