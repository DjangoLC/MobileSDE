package com.example.itijuanatest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.itijuanatest.data.db.Driver
import com.example.itijuanatest.data.db.DriverAndLibrary

@Dao
interface DriverDao {
    @Transaction
    @Query("SELECT * from ${Driver.TABLE_NAME}")
    suspend fun getDriverAndAddress(): DriverAndLibrary

    @Transaction
    @Query("SELECT * from ${Driver.TABLE_NAME}")
    suspend fun getAllDriversAndAddress(): List<DriverAndLibrary>

    @Insert
    suspend fun insertDriver(driver: Driver)

    @Insert
    suspend fun insertDriversList(drivers: List<Driver>)
}