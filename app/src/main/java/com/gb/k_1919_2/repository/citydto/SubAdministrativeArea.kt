package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class SubAdministrativeArea(
    @SerializedName("Locality")
    val locality: LocalityX,
    @SerializedName("SubAdministrativeAreaName")
    val subAdministrativeAreaName: String
)