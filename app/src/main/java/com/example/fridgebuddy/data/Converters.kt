// app/src/main/java/com/example/fridgebuddy/data/Converters.kt
package com.example.fridgebuddy.data

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class Converters {
    private val zone = ZoneId.systemDefault()

    @TypeConverter
    fun fromLocalDate(date: LocalDate): Long =
        date.atStartOfDay(zone).toInstant().toEpochMilli()

    @TypeConverter
    fun toLocalDate(millis: Long): LocalDate =
        Instant.ofEpochMilli(millis).atZone(zone).toLocalDate()
}
