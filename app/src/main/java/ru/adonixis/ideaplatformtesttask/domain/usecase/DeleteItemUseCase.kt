package ru.adonixis.ideaplatformtesttask.domain.usecase

import ru.adonixis.ideaplatformtesttask.data.repository.ItemRepository
import ru.adonixis.ideaplatformtesttask.domain.model.Item
import ru.adonixis.ideaplatformtesttask.domain.model.asItemEntity
import javax.inject.Inject

interface IDeleteItemUseCase {

    suspend operator fun invoke(item: Item)
}

class DeleteItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) : IDeleteItemUseCase {

    override suspend fun invoke(item: Item) {
        itemRepository.delete(item.asItemEntity())
    }
}
