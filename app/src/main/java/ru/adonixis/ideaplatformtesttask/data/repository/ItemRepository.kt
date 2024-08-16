package ru.adonixis.ideaplatformtesttask.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ru.adonixis.ideaplatformtesttask.data.database.ItemDao
import javax.inject.Inject
import javax.inject.Singleton
import ru.adonixis.ideaplatformtesttask.data.model.ItemEntity

interface ItemRepository {

    fun getAll(): Flow<List<ItemEntity>>

    suspend fun delete(item: ItemEntity)

    suspend fun update(item: ItemEntity)
}

@Singleton
class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
) : ItemRepository {

    override fun getAll(): Flow<List<ItemEntity>> = itemDao.getAll()

    override suspend fun delete(item: ItemEntity) {
        withContext(Dispatchers.IO) {
            itemDao.delete(item)
        }
    }

    override suspend fun update(item: ItemEntity) {
        withContext(Dispatchers.IO) {
            itemDao.update(item)
        }
    }
}
