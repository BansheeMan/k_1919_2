package com.gb.k_1919_2.lesson1

import android.view.View


data class Data(val id: Int, var age: Int, val weight: Int = 20)


enum class TestEnum {
    test1,
    test2,
    test3,
    test4,
}

object Database {
    fun getTestIf(): String {
        val result = if (0 == 0) {
            val f12 = 1 + 235423
            val f2 = 1 + 235423
            val f3 = 1 + 235423
            "test"
        } else {
            "мир сошел с ума"
        }

        try {

        }catch (e:Throwable){

        }finally {
            //закрыть соединение с сервером
        }
        return result
    }

    fun getTestWhen(input: TestEnum): String {
        val result = when (input) { //switch
            TestEnum.test1 -> "1"
            TestEnum.test2 -> "2"
            TestEnum.test3 -> "3"
            TestEnum.test4 -> "4"
        }
        return result
    }
}