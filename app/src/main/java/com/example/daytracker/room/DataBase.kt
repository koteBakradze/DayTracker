package com.example.daytracker.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DayEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dayEntryDao(): DayEntryDao
}

abstract class DayDataBase : RoomDatabase(){
    abstract fun dayDao() : DayEntryDao
}