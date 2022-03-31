package com.gb.k_1919_2.lesson4

import android.content.Context
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.gb.k_1919_2.R
import com.gb.k_1919_2.lesson1.Person
import com.gb.k_1919_2.lesson3.Lesson3
import com.gb.k_1919_2.view.MainActivity

class Lesson4 {
    lateinit var lesson3: Lesson3 // 1 способ
    fun some1() { // 1 способ
        lesson3.usual1("some произошло ")
    }

    val pr = 777

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

    private fun funHigh(
        _f: (float: Float) -> Unit,
        __f: (double: Double) -> Short,
        _c: (char: Char) -> Boolean
    ) {
        _f(1f)
        val short = __f(1.0)
        val boolean = _c('f')
    }

    fun main(mainActivity: MainActivity){
        Log.d("@@@","До  $person")
        val newPersonLet = person?.let { it->
            it.age = 10
            it.name = "LetName"
            1
        }
        Log.d("@@@","После  let  $person")
        val newPersonRun = person?.run {
            age = 99
            name = "RunNAme"
            this@Lesson4.pr
            // this.pr Ошибка
            pr
            2
        }
        Log.d("@@@","После  run  $person")
        val newPersonAlso = person?.also {
            it.age = 55
            it.name = "AlsoName"
            3
        }
        Log.d("@@@","После  also  $person")
        val newPersonApply = person?.apply {
            age = 66
            name = "ApplyName"
            4
        }
        Log.d("@@@","После  apply  $person")
        Log.d("@@@","Результат  $newPersonLet")
        Log.d("@@@","Результат  $newPersonRun")
        Log.d("@@@","Результат  $newPersonAlso")
        Log.d("@@@","Результат  $newPersonApply")


        with(person!!){
            age = 66
            name = "ApplyName"
        }

        /** Способ 1 ( не правильниый) **/
        val textView = TextView(mainActivity)
        textView.text = "segewrg"
        textView.textSize = 30f
        mainActivity.findViewById<ConstraintLayout>(R.id.layout).addView(textView)

        /** Способ 2 ( правильниый) **/
        mainActivity.findViewById<ConstraintLayout>(R.id.layout).addView(TextView(mainActivity).apply {
            text = "segewrg"
            textSize = 30f
        })
    }

    private val person:Person? = Person("testName",20)
    fun was(){
        Log.d("@@@","НЕ Был $pr")
    }


}