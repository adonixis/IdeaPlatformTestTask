package ru.adonixis.ideaplatformtesttask.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.adonixis.ideaplatformtesttask.domain.model.Item
import ru.adonixis.ideaplatformtesttask.domain.usecase.IDeleteItemUseCase
import ru.adonixis.ideaplatformtesttask.domain.usecase.IGetAllItemsUseCase
import ru.adonixis.ideaplatformtesttask.domain.usecase.IUpdateItemUseCase
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val getAllItemsUseCase: IGetAllItemsUseCase,
    private val deleteItemUseCase: IDeleteItemUseCase,
    private val updateItemUseCase: IUpdateItemUseCase,
): ViewModel() {

    fun getAll() = getAllItemsUseCase()

    fun delete(item: Item) {
        viewModelScope.launch {
            deleteItemUseCase(item)
        }
    }

    fun update(item: Item) {
        viewModelScope.launch {
            updateItemUseCase(item)
        }
    }
}
