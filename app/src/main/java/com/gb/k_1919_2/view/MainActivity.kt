package com.gb.k_1919_2.view

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.gb.k_1919_2.R
import com.gb.k_1919_2.lesson3.Lesson3
import com.gb.k_1919_2.lesson3.someViewGroup
import com.gb.k_1919_2.lesson4.Lesson4
import com.gb.k_1919_2.lesson4.Speakable
import com.gb.k_1919_2.view.weatherlist.WeatherListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }
        /*val t = 1
        val any:Any = t
        val object1:Objects = t
        val any1:Any = object1
        val object2:Objects = any*/

        val button = Button(this)
        val view1: View = LinearLayout(this)
        val view2: View = TextView(this)
        (view2 as TextView).text = ""
        someViewGroup((view1 as LinearLayout))


        val looperNotNullable: Looper = getMainLooper()
        val looperNullable: Looper? = getMainLooper()

        val lesson3 = Lesson3()
        val lesson4 = Lesson4()
        lesson4.lesson3 = lesson3
        lesson4.some1()//1 способ

        lesson4.f = lesson3.f//2 способ
        lesson4.some2()

        lesson4.speakable = lesson3 //3.1 способ
        lesson4.some3()

        lesson4.speakable = lesson3.callback //3.2 способ
        lesson4.some4()
        lesson4.speakable = lesson3.callbackLambda1 //4.1 способ
        lesson4.some5()

        //lesson4.some6(lesson3.callbackLambda2)
        lesson4.some6 { string: String, i: Int ->
            Log.d("@@@", " Сообщение $string")
            1.0
        }

        lesson4.was()
        lesson4.main(this)



    }

    fun Lesson4.was() {
        Log.d("@@@", "Был ${this.pr}")


    }


}




