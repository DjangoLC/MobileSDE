package com.example.itijuanatest.di.driver

import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import com.example.itijuanatest.core.domain.usecases.GetAllDrivers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DriverUseCases {

    @Provides
    @ViewModelScoped
    fun provideGetAllDriversUseCase(driversRepository: DriversRepository) =
        GetAllDrivers(driversRepository)

}