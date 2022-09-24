package com.example.itijuanatest.di.shipment

import com.example.itijuanatest.core.data.repositories.shipment.ShipmentRepository
import com.example.itijuanatest.core.domain.StringUtils
import com.example.itijuanatest.core.domain.UtilsMath
import com.example.itijuanatest.core.domain.usecases.CalculateBestShipmentByDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ShipmentUseCases {

    @Provides
    @ViewModelScoped
    fun provideGetShipmentsUseCase(shipmentRepository: ShipmentRepository) =
        CalculateBestShipmentByDriver(shipmentRepository, UtilsMath(), StringUtils())

}