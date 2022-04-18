package com.gb.k_1919_2.repository.citydto


import com.google.gson.annotations.SerializedName

data class BoundedBy(
    @SerializedName("Envelope")
    val envelope: Envelope
)