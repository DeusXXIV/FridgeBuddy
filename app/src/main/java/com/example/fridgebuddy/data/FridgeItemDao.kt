// app/src/main/java/com/example/fridgebuddy/data/FridgeItemDao.kt
package com.example.fridgebuddy.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FridgeItemDao {
    @Query("SELECT * FROM FridgeItem ORDER BY expirationDate ASC")
    fun getAllItems(): Flow<List<FridgeItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: FridgeItem): Long

    @Delete
    suspend fun delete(item: FridgeItem)
}
