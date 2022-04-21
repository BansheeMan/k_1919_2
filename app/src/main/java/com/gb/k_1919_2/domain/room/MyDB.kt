package com.gb.k_1919_2.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(HistoryEntity::class), version = 2)
abstract class MyDB:RoomDatabase() {
    abstract fun historyDao():HistoryDao
    //abstract fun historyDao1():HistoryDao1
}