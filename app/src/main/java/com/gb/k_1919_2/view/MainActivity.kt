package com.gb.k_1919_2.view

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.gb.k_1919_2.R
import com.gb.k_1919_2.lesson3.Lesson3
import com.gb.k_1919_2.lesson3.someViewGroup
import com.gb.k_1919_2.lesson4.BaseImpl
import com.gb.k_1919_2.lesson4.BossDelegate
import com.gb.k_1919_2.lesson4.Lesson4
import com.gb.k_1919_2.lesson4.Speakable
import com.gb.k_1919_2.lesson6.ThreadsFragment
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
        with(lesson4) {
            this.lesson3 = lesson3
            some1()//1 способ
            f = lesson3.f//2 способ
            some2()
            speakable = lesson3 //3.1 способ
            some3()
            speakable = lesson3.callback //3.2 способ
            some4()
            speakable = lesson3.callbackLambda1 //4.1 способ
            some5()
            //some6(lesson3.callbackLambda2)
            some6 { string: String, i: Int ->
                Log.d("@@@", " Сообщение $string")
                1.0
            }
            was()
            //main(this@MainActivity)
        }

        val worker = BaseImpl()
        BossDelegate(worker, worker).run {
            manipulate()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_threads->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ThreadsFragment.newInstance()).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun Lesson4.was() {
        Log.d("@@@", "Был ${this.pr}")
    }


}




