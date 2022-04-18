package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("GeoObjectCollection")
    val geoObjectCollection: GeoObjectCollectionX
)