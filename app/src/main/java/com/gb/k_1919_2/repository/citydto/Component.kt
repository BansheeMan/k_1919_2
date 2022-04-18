package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class Component(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("name")
    val name: String
)