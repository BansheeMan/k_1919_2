package com.gb.k_1919_2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_1919_2.repository.*

class DetailsViewModel(
    private val liveData: MutableLiveData<DetailsState> = MutableLiveData(),
    private val repository: DetailsRepository = DetailsRepositoryRetrofit2Impl()
) :ViewModel() {

    fun getLiveData()=liveData

    fun getWeather(city: City){
        liveData.postValue(DetailsState.Loading)
        repository.getWeatherDetails(city,object :Callback{
            override fun onResponse(weather: Weather) {
                liveData.postValue(DetailsState.Success(weather))
            }
        })
    }

    interface Callback {
        fun onResponse(weather: Weather)
        // TODO HW Fail
    }



}