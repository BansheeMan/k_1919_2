package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class DependentLocalityXXX(
    @SerializedName("DependentLocality")
    val dependentLocality: DependentLocalityXXXX,
    @SerializedName("DependentLocalityName")
    val dependentLocalityName: String
)