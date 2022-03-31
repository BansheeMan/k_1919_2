package com.gb.k_1919_2.lesson4

import android.util.Log


interface Base1 {
    fun someFun1()
}

interface Base2 {
    fun someFun2()
}

class BaseImpl() : Base1, Base2 {
    override fun someFun1() {
        Log.d("@@@", "someFun1()")
    }

    override fun someFun2() {
        Log.d("@@@", "someFun2()")
    }
}


class BossDelegate(someBase1:Base1,someBase2:Base2): Base1 by someBase1, Base2 by someBase2  {
    fun manipulate(){
        someFun1()
        someFun2()
    }
}