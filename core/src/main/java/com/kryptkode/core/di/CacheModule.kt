package com.kryptkode.core.di

import android.content.Context
import com.kryptkode.core.cache.AppDatabase
import com.kryptkode.core.cache.character.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CacheModule {

    companion object {

        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
            return AppDatabase.getInstance(context)
        }

        @Provides
        @Singleton
        fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao {
            return appDatabase.charactersDao()
        }
    }
}
