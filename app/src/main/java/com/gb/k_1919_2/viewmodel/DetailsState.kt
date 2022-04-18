package com.gb.k_1919_2.viewmodel

import com.gb.k_1919_2.repository.Weather

sealed class DetailsState {
    object Loading:DetailsState()
    data class Success(val weather:Weather):DetailsState()
    data class Error(val error:Throwable):DetailsState()
}
