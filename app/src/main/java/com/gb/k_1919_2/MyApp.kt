package com.gb.k_1919_2

import android.app.Application
import androidx.room.Room
import com.gb.k_1919_2.domain.room.HistoryDao
import com.gb.k_1919_2.domain.room.MyDB

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object{
        private var db:MyDB?=null
        private var appContext:MyApp?=null
        fun getHistoryDao():HistoryDao{
            if(db==null){
                if(appContext!=null){
                    db = Room.databaseBuilder(appContext!!,MyDB::class.java,"test")
                        .allowMainThreadQueries() // TODO HW а вам нужно придумать что-то другое
                        .build()
                }else{
                    throw IllegalStateException("что-то пошло не так, и у нас пустое appContext")
                }
            }
            return db!!.historyDao()
        }
    }
}