package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("AddressLine")
    val addressLine: String,
    @SerializedName("AdministrativeArea")
    val administrativeArea: AdministrativeArea,
    @SerializedName("CountryName")
    val countryName: String,
    @SerializedName("CountryNameCode")
    val countryNameCode: String,
    @SerializedName("Locality")
    val locality: LocalityXX
)