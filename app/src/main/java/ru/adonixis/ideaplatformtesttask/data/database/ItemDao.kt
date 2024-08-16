package ru.adonixis.ideaplatformtesttask.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.adonixis.ideaplatformtesttask.data.model.ItemEntity

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): Flow<List<ItemEntity>>

    @Delete
    suspend fun delete(item: ItemEntity)

    @Update
    suspend fun update(item: ItemEntity)
}
