package com.gb.k_1919_2.viewmodel

import com.gb.k_1919_2.repository.Weather

sealed class AppState {
    object Loading:AppState()
    data class Success(val weatherList:List<Weather>):AppState(){
        fun test(){}
    }
    data class Error(val error:Throwable):AppState()
}
