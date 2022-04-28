package com.gb.k_1919_2.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey


const val ID = "id"
const val NAME = "city"
const val TEMPERATURE = "temperature"
const val FEELS_LIKE = "feelsLike"
const val ICON = "icon"
const val CONDITION = "condition"
@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val city: String,
   /* val timestamp: Long, TODO HW первичный ключ связка city+timestamp ???  */
    val temperature: Int,
    val feelsLike: Int=10,
    val icon: String="skn_n",
    val condition: String = "cloudy"
)
