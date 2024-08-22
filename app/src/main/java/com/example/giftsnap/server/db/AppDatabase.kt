package com.example.giftsnap.server.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.giftsnap.server.dao.CashEntryDao
import com.example.giftsnap.server.dao.GiftDao
import com.example.giftsnap.server.entity.CashEntry
import com.example.giftsnap.server.entity.Gift
import com.example.giftsnap.server.utils.DateConverter

@Database(entities = [Gift::class, CashEntry::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun giftDao(): GiftDao
    abstract fun cashEntryDao(): CashEntryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "wedding_gifts_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}