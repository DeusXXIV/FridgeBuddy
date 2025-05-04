// app/src/main/java/com/example/fridgebuddy/data/FridgeItem.kt
package com.example.fridgebuddy.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class FridgeItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val quantity: Int,
    val addedDate: LocalDate,
    val expirationDate: LocalDate,   // ← must match your SQL column
    val notes: String? = null
)
