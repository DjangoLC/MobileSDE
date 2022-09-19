package com.example.itijuanatest.di

import com.example.itijuanatest.core.data.datasource.DriversLocalDataSource
import com.example.itijuanatest.data.DriversLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideDriversLocalDataSource(): DriversLocalDataSource = DriversLocalDataSourceImpl()

}