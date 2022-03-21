package com.gb.k_1919_2.lesson1




data class Data(val id:Int,var age:Int,val weight:Int=20)



object Database{
    fun getTest():String{
        if(0==0){
            return "test"
        }else{
            return "мир сошел с ума"
        }
    }
}