package com.gb.k_1919_2.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val city: String,
   /* val timestamp: Long, TODO HW первичный ключ связка city+timestamp ???  */
    val temperature: Int,
    val feelsLike: Int,
    val icon: String
)
