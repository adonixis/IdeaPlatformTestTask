package ru.adonixis.ideaplatformtesttask.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.adonixis.ideaplatformtesttask.domain.usecase.DeleteItemUseCase
import ru.adonixis.ideaplatformtesttask.domain.usecase.GetAllItemsUseCase
import ru.adonixis.ideaplatformtesttask.domain.usecase.IDeleteItemUseCase
import ru.adonixis.ideaplatformtesttask.domain.usecase.IGetAllItemsUseCase
import ru.adonixis.ideaplatformtesttask.domain.usecase.IUpdateItemUseCase
import ru.adonixis.ideaplatformtesttask.domain.usecase.UpdateItemUseCase

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetAllItemsUseCase(impl: GetAllItemsUseCase): IGetAllItemsUseCase

    @Binds
    fun bindDeleteItemUseCase(impl: DeleteItemUseCase): IDeleteItemUseCase


    @Binds
    fun bindUpdateItemUseCase(impl: UpdateItemUseCase): IUpdateItemUseCase
}
