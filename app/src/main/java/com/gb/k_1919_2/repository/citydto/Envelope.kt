package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class Envelope(
    @SerializedName("lowerCorner")
    val lowerCorner: String,
    @SerializedName("upperCorner")
    val upperCorner: String
)