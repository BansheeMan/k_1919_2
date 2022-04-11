package com.gb.k_1919_2.viewmodel

import com.gb.k_1919_2.repository.Weather

sealed class ResponseState {
    object Error1:ResponseState()
    data class Error2(val weatherList:List<Weather>):ResponseState(){
        fun test(){}
    }
    data class Error3(val error:Throwable):ResponseState()
}
