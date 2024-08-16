package ru.adonixis.ideaplatformtesttask.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.adonixis.ideaplatformtesttask.data.repository.ItemRepository
import ru.adonixis.ideaplatformtesttask.domain.model.Item
import ru.adonixis.ideaplatformtesttask.domain.model.asItem
import javax.inject.Inject

interface IGetAllItemsUseCase {

    operator fun invoke(): Flow<List<Item>>
}

class GetAllItemsUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) : IGetAllItemsUseCase {

    override fun invoke() = itemRepository.getAll().map { it.map { it.asItem() } }
}
