package com.gb.k_1919_2.lesson1

import android.content.Context
import android.util.AttributeSet
import android.view.View

internal open class Person constructor(val name: String = "defaultName", var age: Int = 20) {

    fun test(testParam: String = "edrfgedr") {
        var temp:Int= testParamNull ?: 0
        alex(temp)
    }

    var testParamNoNull: Int = 1
    var testParamNull: Int? = null
    lateinit var s: String

    fun alex(s: Int) {

    }
}
