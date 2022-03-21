package com.gb.k_1919_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.gb.k_1919_2.lesson1.Person
import com.gb.k_1919_2.lesson1.test

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test("")

        Person(age=30,name="newName").test()
    }
}

