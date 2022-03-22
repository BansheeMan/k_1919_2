package com.gb.k_1919_2.lesson1

import android.content.Context
import android.util.AttributeSet
import android.view.View

internal open class Person constructor(val name:String="defaultName",var age:Int=20) {

    fun test(testParam:String="edrfgedr"){
        testParam2 = "dsefrg"
        val testParam3 = testParam2
        val javaText :JavaTest = JavaTest()
        JavaTest().i

    }

    var p =""
    get() {
        return field
    }
    set(p0:String) {
        field = p0
    }


    lateinit var testParam2:String //TODO Int примитив (127)

//    init{
//        testParam2 = "rewsg"
//    }
    constructor(name:String,age:Int,descr:String):this(name,age){
    }
    constructor(name:String,age:Int,descr1:String,descr2:String):this(name,age,descr1){
    }
    constructor(name:String,age:Int,descr1:String,descr2:String,descr3:String):this(name,age,descr1,descr2){
    }
}



internal class Student(name:String,age:Int) : Person(name,age), View.OnClickListener,Testable1,Testable2,Testable3,Testable4,Testable5{

    override fun onClick(p0: View?) {

    }

}

class Button @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr:Int?=null, defStyleRes:Int?=null){

}