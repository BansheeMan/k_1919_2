package com.gb.k_1919_2.lesson3

import android.util.Log
import com.gb.k_1919_2.lesson1.Person


class Lesson3 {
    fun test(){
        val people:List<Person> = mutableListOf(Person("name1",20),Person("name2",22))
        people.get(0).age
        people[0].age
        people.size
        val peopleHack = people.toMutableList()
        val peopleAge:List<Person> =people.filter { it.age>20 }

        val arr1 = arrayOf(1,2,3,4,5,6,7,8,9,10)
        val arr2 = arr1.map { it*2 }
        peopleHack.add(Person("name1",20))

    }
}

interface Flyable{
    val i :Int
    fun test()
    fun test2()
    fun test3(){
        Log.d("","$i")
    }
}