package com.kryptkode.core.di

import com.kryptkode.core.BuildConfig
import com.kryptkode.core.remote.api.SwahPeeServiceApi
import com.kryptkode.core.remote.api.SwahPeeServiceApiFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {

    companion object {
        @Provides
        @Singleton
        fun provideMoshi(): Moshi {
            return Moshi.Builder().build()
        }

        @Provides
        fun provideSwahPeeService(moshi: Moshi): SwahPeeServiceApi {
            return SwahPeeServiceApiFactory.makeSwahPeeService(moshi, BuildConfig.DEBUG)
        }
    }
}
