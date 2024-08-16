package ru.adonixis.ideaplatformtesttask.data.di

import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.adonixis.ideaplatformtesttask.data.database.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    @Singleton
    fun provideItemDao(appDatabase: AppDatabase) = appDatabase.itemDao()
}
