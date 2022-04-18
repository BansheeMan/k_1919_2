package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class LocalityXX(
    @SerializedName("DependentLocality")
    val dependentLocality: DependentLocalityXXXXX,
    @SerializedName("LocalityName")
    val localityName: String
)