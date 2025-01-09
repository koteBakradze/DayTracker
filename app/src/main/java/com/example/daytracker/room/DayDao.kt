package com.example.daytracker.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DayEntryDao {
    @Insert
    fun insert(dayEntry: DayEntry)

    @Query("SELECT * FROM day_entries WHERE year = :year AND month = :month AND day = :day")
    fun getDayEntry(year: Int, month: Int, day: Int): DayEntry?

    @Query("select * from day_entries")
    fun getAllDays(): Flow<List<DayEntry>>

    @Update
    suspend fun updateDay(wishEntity: DayEntry)

    @Delete
    suspend fun deleteDay(wishEntity: DayEntry)

    @Query("select * from day_entries where id = :id")
    fun getDayById(id:Long): Flow<DayEntry>
}