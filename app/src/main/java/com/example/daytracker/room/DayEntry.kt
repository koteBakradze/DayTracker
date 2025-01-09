package com.example.daytracker.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_entries")
data class DayEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val year: Int,
    val month: Int,
    val day: Int,
    val isGoodDay: Boolean
)
