package ru.adonixis.ideaplatformtesttask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val time: Instant,
    val tags: List<String>,
    val amount: Int
)
