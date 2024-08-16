package ru.adonixis.ideaplatformtesttask.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.adonixis.ideaplatformtesttask.data.repository.ItemRepository
import ru.adonixis.ideaplatformtesttask.data.repository.ItemRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindItemRepository(impl: ItemRepositoryImpl): ItemRepository
}
