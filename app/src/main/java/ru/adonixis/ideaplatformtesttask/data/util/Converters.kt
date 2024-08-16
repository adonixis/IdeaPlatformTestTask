package ru.adonixis.ideaplatformtesttask.data.util

import androidx.room.TypeConverter
import kotlinx.datetime.Instant

object InstantConverter {

    @TypeConverter
    fun fromEpochMillis(epochMillis: Long): Instant {
        return Instant.fromEpochMilliseconds(epochMillis)
    }

    @TypeConverter
    fun toEpochMillis(instant: Instant): Long {
        return instant.toEpochMilliseconds()
    }
}

object TagsConverter {

    @TypeConverter
    fun fromTags(tags: List<String>): String {
        return tags.joinToString(
            separator = ", ",
            prefix = "[",
            postfix = "]",
            transform = { str -> "\"" + str + "\"" })
    }

    @TypeConverter
    fun toTags(tags: String): List<String> {
        return tags
            .removePrefix("[")
            .removeSuffix("]")
            .split(", ")
            .let { if (it.size == 1 && it[0].isEmpty()) emptyList() else it }
            .map { str -> str.removePrefix("\"").removeSuffix("\"") }
    }
}
