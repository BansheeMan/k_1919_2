package com.gb.k_1919_2.lesson4

import android.util.Log
import com.gb.k_1919_2.lesson3.Lesson3

class Lesson4 {
        lateinit var lesson3:Lesson3 // 1 способ
    fun some1(){ // 1 способ
        lesson3.usual1("some произошло ")
    }


    var f = fun (string:String){}
    fun some2(){ // 1 способ
        f("some произошло 2 способ ")
    }


    lateinit var speakable:Speakable
    fun some3(){ // 3.1 способ
        speakable.f("some произошло 3.1 способ ",1)
    }


    fun some4(){ // 3.2 способ
        speakable.f("some произошло 3.2 способ ",1)
    }
    fun some5(){ // 4.1 способ
        speakable.f("some произошло 4.1 способ ",1)
    }
    fun some6( _speakable:Speakable){ // 4.2 способ
        _speakable.f("some произошло 4.2 способ ",1)
    }
}