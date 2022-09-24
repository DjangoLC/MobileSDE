package com.example.itijuanatest.di.shipment

import com.example.itijuanatest.core.data.datasource.ShipmentsDbDataSource
import com.example.itijuanatest.core.data.datasource.ShipmentsFileDataSource
import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepository
import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ShipmentRepoModule {
    @ViewModelScoped
    @Provides
    fun provideShipmentRepository(localDataSource: ShipmentsFileDataSource, shipmentsDbDataSource: ShipmentsDbDataSource):
            ShipmentRepository = ShipmentRepositoryImpl(localDataSource, shipmentsDbDataSource)
}