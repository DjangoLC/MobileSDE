package com.example.itijuanatest.di.shipment

import com.example.itijuanatest.core.data.datasource.ShipmentsLocalDataSource
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
    fun provideShipmentRepository(localDataSource: ShipmentsLocalDataSource):
            ShipmentRepository = ShipmentRepositoryImpl(localDataSource)
}