package com.gb.k_1919_2.domain.room

import androidx.room.*


@Dao
interface HistoryDao {
    @Query("INSERT INTO history_table (city,temperature,feelsLike,icon) VALUES(:city,:temperature,:feelsLike,:icon)")
    fun nativeInsert(city: String, temperature: Int, feelsLike: Int, icon: String)

   /* @Query("SELECT city_table.name,weather_table.temperature " +
            "FROM city_table,weather_table  WHERE city_table.name=:cityName AND  weather_table.city_id==city_table.id")
    fun someSelect(cityName: String)*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: HistoryEntity)

    @Delete
    fun delete(entity: HistoryEntity)

    @Update
    fun update(entity: HistoryEntity)

    @Query("SELECT * FROM history_table")
    fun getAll():List<HistoryEntity>

    @Query("SELECT * FROM history_table WHERE city=:city")
    fun getHistoryForCity(city:String):List<HistoryEntity>

}