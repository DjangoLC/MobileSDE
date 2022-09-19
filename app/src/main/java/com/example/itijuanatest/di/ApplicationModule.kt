package com.example.itijuanatest.di

import android.content.Context
import com.example.itijuanatest.core.data.datasource.DriversLocalDataSource
import com.example.itijuanatest.core.data.datasource.ShipmentsLocalDataSource
import com.example.itijuanatest.data.driverLocal.DriversLocalDataSourceImpl
import com.example.itijuanatest.data.driverLocal.ParserRawDriverData
import com.example.itijuanatest.data.shipmentLocal.ParserRawShipmentData
import com.example.itijuanatest.data.shipmentLocal.ShipmentsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    fun provideUiDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Singleton
    fun provideParserRawDriverData(@ApplicationContext appContext: Context) : ParserRawDriverData {
        return ParserRawDriverData(appContext)
    }

    @Provides
    @Singleton
    fun provideParserRawShipmentData(@ApplicationContext appContext: Context) : ParserRawShipmentData {
        return ParserRawShipmentData(appContext)
    }

    @Provides
    @Singleton
    fun provideDriversLocalDataSource(parserRawDriverData: ParserRawDriverData): DriversLocalDataSource = DriversLocalDataSourceImpl(parserRawDriverData)

    @Provides
    @Singleton
    fun provideShipmentsLocalDataSource(parserRawShipmentData: ParserRawShipmentData): ShipmentsLocalDataSource = ShipmentsLocalDataSourceImpl(parserRawShipmentData)

}