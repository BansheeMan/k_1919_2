package com.gb.k_1919_2.repository

import com.gb.k_1919_2.MyApp
import com.gb.k_1919_2.utlis.convertHistoryEntityToWeather
import com.gb.k_1919_2.utlis.convertWeatherToEntity
import com.gb.k_1919_2.viewmodel.DetailsViewModel
import com.gb.k_1919_2.viewmodel.HistoryViewModel

class DetailsRepositoryRoomImpl:DetailsRepositoryOne,DetailsRepositoryAll,DetailsRepositoryAdd {
    override fun getAllWeatherDetails(callback: HistoryViewModel.CallbackForAll) {
        Thread{
            callback.onResponse(convertHistoryEntityToWeather(MyApp.getHistoryDao().getAll()))
        }.start()
    }

    override fun getWeatherDetails(city: City, callback: DetailsViewModel.Callback) {
        val list =convertHistoryEntityToWeather(MyApp.getHistoryDao().getHistoryForCity(city.name))
        if(list.isEmpty()){
            callback.onFail() // то и отобразить нечего
        }else{
            callback.onResponse(list.last()) // FIXME hack
        }

    }

    override fun addWeather(weather: Weather) {
        MyApp.getHistoryDao().insert(convertWeatherToEntity(weather))
    }

}