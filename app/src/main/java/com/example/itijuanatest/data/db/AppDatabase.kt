package com.example.itijuanatest.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.itijuanatest.data.db.dao.DriverDao
import com.example.itijuanatest.data.db.dao.ShipmentDao

@Database(entities = [Driver::class, Shipment::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun driversDao(): DriverDao
    abstract fun shipmentsDao(): ShipmentDao

    companion object {

        const val DB_NAME = "app-database"

        fun buildDatabase(appContext: Context): AppDatabase {
            return Room.databaseBuilder(
                appContext,
                AppDatabase::class.java, DB_NAME
            ).build()
        }
    }
}