package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class AddressDetails(
    @SerializedName("Address")
    val address: String,
    @SerializedName("Country")
    val country: Country
)