package com.gb.k_1919_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.gb.k_1919_2.lesson1.*
import com.gb.k_1919_2.lesson1.Person

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test("")

        Person(age=30,name="newName").test()
        JavaTestNew().foo()


        val data1 = Data(1,1,1)
        val data2 = data1.copy()
        data2.age = 100

        Log.d("mylogs","${data1.age}")
        Log.d("mylogs","${data2.toString()}")
        Log.d("mylogs","${data2.equals(data1)}")
        Log.d("mylogs","${Database.getTest()}")
    }
}

class JavaTestNew:JavaTest(){
    fun foo():Int{
        return i
    }
}


