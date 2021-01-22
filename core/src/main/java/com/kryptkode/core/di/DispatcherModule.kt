package com.kryptkode.core.di

import com.kryptkode.core.dispatchers.AppDispatchers
import com.kryptkode.core.dispatchers.AppDispatchersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DispatcherModule {

    @Binds
    @Singleton
    fun provideDispatcher(swahPeeDispatchers: AppDispatchersImpl): AppDispatchers
}
