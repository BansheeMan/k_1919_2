package com.gb.k_1919_2.lesson4

import android.util.Log
import com.gb.k_1919_2.lesson3.Lesson3

class Lesson4 {
    lateinit var lesson3: Lesson3 // 1 способ
    fun some1() { // 1 способ
        lesson3.usual1("some произошло ")
    }


    var f = fun(string: String) {}
    fun some2() { // 1 способ
        f("some произошло 2 способ ")
    }


    lateinit var speakable: Speakable
    fun some3() { // 3.1 способ
        speakable.f("some произошло 3.1 способ ", 1)
    }


    fun some4() { // 3.2 способ
        speakable.f("some произошло 3.2 способ ", 1)
    }

    fun some5() { // 4.1 способ
        speakable.f("some произошло 4.1 способ ", 1)
    }

    fun some6(_speakable: Speakable) { // 4.2 способ
        _speakable.f("some произошло 4.2 способ ", 1)
    }

    val _f = fun(float: Float): Unit {

    }
    val __f = fun(double: Double): Short {
        return 1
    }
    val _c = fun(char: Char): Boolean {
        return true
    }

    fun funHigh(
        _f: (float: Float) -> Unit,
        __f: (double: Double) -> Short,
        _c: (char: Char) -> Boolean
    ) {
        _f(1f)
        val short = __f(1.0)
        val boolean = _c('f')
    }

    fun main(){
        funHigh(_f,__f,_c)
    }

}