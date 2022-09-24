package com.example.itijuanatest.di.driver

import com.example.itijuanatest.core.data.datasource.DriversDbDataSource
import com.example.itijuanatest.core.data.datasource.DriversFileDataSource
import com.example.itijuanatest.core.data.repositories.driver.DriversRepository
import com.example.itijuanatest.core.data.repositories.driver.DriversRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DriverRepoModule {
    @ViewModelScoped
    @Provides
    fun provideDriverRepository(localDataSource: DriversFileDataSource,driversDbDataSource: DriversDbDataSource ):
            DriversRepository = DriversRepositoryImpl(localDataSource, driversDbDataSource)
}