package com.example.daytracker.room

import kotlinx.coroutines.flow.Flow

class DayRepository(private val dayDao: DayEntryDao) {

    fun addDay(day:DayEntry){
        dayDao.insert(day)
    }

    fun getWishes(): Flow<List<DayEntry>> = dayDao.getAllDays()

    fun getWishById(id:Long) : Flow<DayEntry> {
        return dayDao.getDayById(id)
    }

    suspend fun updateWish(day:DayEntry){
        dayDao.updateDay(day)
    }

    suspend fun deleteWish(day: DayEntry){
        dayDao.deleteDay(day)
    }
}