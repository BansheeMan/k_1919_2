package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class FeatureMember(
    @SerializedName("GeoObject")
    val geoObject: GeoObject
)