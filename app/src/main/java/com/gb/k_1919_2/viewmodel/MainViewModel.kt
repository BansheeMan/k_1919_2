package com.gb.k_1919_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_1919_2.repository.Repository
import com.gb.k_1919_2.repository.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImpl = RepositoryImpl()
) :
    ViewModel() {

    fun getData(): LiveData<AppState> {
        return liveData
    }


    fun getWeatherRussia() = getWeather(true)
    fun getWeatherWorld() = getWeather(false)


    private fun getWeather(isRussian:Boolean) {
        Thread {
            liveData.postValue(AppState.Loading)
            //if ((0..10).random() > 0){
            if (true){
                val answer = if(!isRussian) repository.getWorldWeatherFromLocalStorage() else repository.getRussianWeatherFromLocalStorage()
                liveData.postValue(AppState.Success(answer))
            }
            else
                liveData.postValue(AppState.Error(IllegalAccessException()))
        }.start()
    }

}