package com.gb.k_1919_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_1919_2.repository.*
import java.lang.Thread.sleep

class HistoryViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: DetailsRepositoryRoomImpl = DetailsRepositoryRoomImpl()
) :
    ViewModel() {

    fun getData(): LiveData<AppState> {
        return liveData
    }

    fun getAll(){
        repository.getAllWeatherDetails(object :CallbackForAll{
            override fun onResponse(listWeather: List<Weather>) {
                liveData.postValue(AppState.Success(listWeather))
            }

            override fun onFail() {
                TODO("Not yet implemented")
            }

        })
    }

    interface CallbackForAll {
        fun onResponse(listWeather: List<Weather>)
        // TODO HW Fail
        fun onFail()
    }


}