package com.example.itijuanatest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.itijuanatest.data.db.Driver
import com.example.itijuanatest.data.db.DriverAndLibrary
import kotlinx.coroutines.flow.Flow

@Dao
interface DriverDao {
    @Transaction
    @Query("SELECT * FROM ${Driver.TABLE_NAME}")
    suspend fun getDriverAndAddress(): DriverAndLibrary

    @Transaction
    @Query("SELECT * FROM ${Driver.TABLE_NAME}")
    suspend fun getAllDriversAndAddress(): List<DriverAndLibrary>

    @Insert
    suspend fun insertDriver(driver: Driver)

    @Insert
    suspend fun insertDriversList(drivers: List<Driver>)

    @Query("SELECT * FROM ${Driver.TABLE_NAME}")
    fun getAllDrivers(): Flow<List<Driver>>

    @Query("SELECT COUNT(id) FROM ${Driver.TABLE_NAME}")
    suspend fun driversCount(): Int
}