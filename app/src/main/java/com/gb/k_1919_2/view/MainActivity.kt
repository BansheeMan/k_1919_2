package com.gb.k_1919_2.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gb.k_1919_2.R
import com.gb.k_1919_2.lesson3.someViewGroup
import com.gb.k_1919_2.view.main.MainFragment
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commit()
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


    }
}


