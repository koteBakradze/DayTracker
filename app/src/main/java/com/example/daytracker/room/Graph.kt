package com.example.daytracker.room

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: DayDataBase

    val dayRepository by lazy {
        DayRepository(dayDao = database.dayDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(
            context,
            DayDataBase::class.java,
            "daylist.db"
        ).build()
    }
}