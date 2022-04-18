package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class AdministrativeArea(
    @SerializedName("AdministrativeAreaName")
    val administrativeAreaName: String,
    @SerializedName("Locality")
    val locality: Locality,
    @SerializedName("SubAdministrativeArea")
    val subAdministrativeArea: SubAdministrativeArea
)