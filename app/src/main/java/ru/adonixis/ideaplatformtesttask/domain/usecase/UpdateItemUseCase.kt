package ru.adonixis.ideaplatformtesttask.domain.usecase

import ru.adonixis.ideaplatformtesttask.data.repository.ItemRepository
import ru.adonixis.ideaplatformtesttask.domain.model.Item
import ru.adonixis.ideaplatformtesttask.domain.model.asItemEntity
import javax.inject.Inject

interface IUpdateItemUseCase {

    suspend operator fun invoke(item: Item)
}

class UpdateItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) : IUpdateItemUseCase {

    override suspend fun invoke(item: Item) {
        itemRepository.update(item.asItemEntity())
    }
}
