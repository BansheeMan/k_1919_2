package com.gb.k_1919_2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.k_1919_2.repository.*

class DetailsViewModel(
    private val liveData: MutableLiveData<DetailsState> = MutableLiveData(),
    private val repositoryAdd: DetailsRepositoryAdd = DetailsRepositoryRoomImpl()
) : ViewModel() {

    private var repositoryOne: DetailsRepositoryOne = DetailsRepositoryOneRetrofit2Impl()


    fun getLiveData() = liveData

    fun getWeather(city: City) {
        liveData.postValue(DetailsState.Loading)
        repositoryOne = if (isInternet()) {
            DetailsRepositoryOneRetrofit2Impl()
        } else {
            DetailsRepositoryRoomImpl()
        }
        repositoryOne.getWeatherDetails(city, object : Callback {
            override fun onResponse(weather: Weather) {
                liveData.postValue(DetailsState.Success(weather))
                if (isInternet()){
                    repositoryAdd.addWeather(weather)
                }
            }

            override fun onFail() {
                //  TODO HW   liveData.postValue(DetailsState.Error()) ("Not yet implemented")
            }
        })


    }

    private fun isInternet(): Boolean {
        //!!! заглушка
        return true
    }

    interface Callback {
        fun onResponse(weather: Weather)

        // TODO HW Fail
        fun onFail()
    }


}