package com.gb.k_1919_2.repository

import com.gb.k_1919_2.viewmodel.ResponseState

fun interface OnServerResponseListener {
    fun onError(error: ResponseState)
}