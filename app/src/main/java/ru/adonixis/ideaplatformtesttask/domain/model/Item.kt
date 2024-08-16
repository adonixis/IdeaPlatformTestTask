package ru.adonixis.ideaplatformtesttask.domain.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kotlinx.datetime.Instant
import ru.adonixis.ideaplatformtesttask.data.model.ItemEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Immutable
data class Item(
    val id: Int,
    val name: String,
    val time: Instant,
    val tags: List<String>,
    val amount: Int
)

@Stable
internal fun ItemEntity.asItem(): Item = with(this) {
    Item(
        id = id,
        name = name,
        time = time,
        tags = tags,
        amount = amount
    )
}

@Stable
internal fun Item.asItemEntity(): ItemEntity = with(this) {
    ItemEntity(
        id = id,
        name = name,
        time = time,
        tags = tags,
        amount = amount
    )
}

@Stable
internal fun Instant.toFormattedDate(): String {
    val date = Date(toEpochMilliseconds())
    val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val formattedDate = formatter.format(date)
    return formattedDate
}
