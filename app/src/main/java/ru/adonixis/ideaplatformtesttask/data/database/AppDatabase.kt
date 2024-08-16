package ru.adonixis.ideaplatformtesttask.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.adonixis.ideaplatformtesttask.data.util.InstantConverter
import ru.adonixis.ideaplatformtesttask.data.util.TagsConverter
import ru.adonixis.ideaplatformtesttask.data.model.ItemEntity
import kotlin.jvm.java

@Database(entities = [ItemEntity::class], version = 1)
@TypeConverters(InstantConverter::class, TagsConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {

        private const val DATABASE_NAME = "data"
        private const val ASSET_DATABASE_FILE = "database/data.db"

        fun getInstance(context: Context): AppDatabase =
            Room.databaseBuilder(
                context = context,
                klass = AppDatabase::class.java,
                name = DATABASE_NAME
            )
                .createFromAsset(ASSET_DATABASE_FILE)
                .build()
    }
}
