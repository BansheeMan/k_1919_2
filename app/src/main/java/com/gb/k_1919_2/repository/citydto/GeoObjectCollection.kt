package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class GeoObjectCollection(
    @SerializedName("response")
    val response: Response
)