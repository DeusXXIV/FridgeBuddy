package com.example.fridgebuddy.data

import kotlinx.coroutines.flow.Flow

class FridgeRepository(private val dao: FridgeItemDao) {

    fun getAllItems(): Flow<List<FridgeItem>> = dao.getAllItems()

    suspend fun addOrUpdate(item: FridgeItem): Long = dao.upsert(item)

    suspend fun delete(item: FridgeItem) = dao.delete(item)
}
