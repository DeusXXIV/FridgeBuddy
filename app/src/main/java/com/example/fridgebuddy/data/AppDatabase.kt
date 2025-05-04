// app/src/main/java/com/example/fridgebuddy/data/AppDatabase.kt
package com.example.fridgebuddy.data

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [FridgeItem::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fridgeItemDao(): FridgeItemDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "fridge_db"
            )
                .addMigrations(MIGRATION_1_2)
                .build()

        // Migration 1→2: add expirationDate column
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE FridgeItem ADD COLUMN expirationDate INTEGER NOT NULL DEFAULT 0"
                )
            }
        }
    }
}
