package com.gb.k_1919_2.lesson1;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class JavaTest   {

    /*public void mainMyConsumer(){
        List<Person> peoplePerson = new ArrayList<Person>();
        List<? extends Object> peopleObject = peoplePerson;
        peopleObject.add(new Object()); // не можем ничего добавить
        Object object=  peopleObject.get(0);
    }
    public void mainMyProducer(){
        List<Object> peopleObject = new ArrayList<Object>();
        List<? super Person>  peoplePerson= peopleObject;
        peoplePerson.add(new Person("wr",12)); // могу добавить
        Person person=  peoplePerson.get(0); // не можем получить
    }*/

    protected int i = 0;
    public void mainMy(){
        String s =null;
        s = "seg";
        String temp;
        if(s!=null){
            temp = s;
        }else{
            temp = "";
        }
        temp = null;
        Log.d("mylogs",temp);
        s =null;
        if(s!=null)
        Log.d("mylogs",s);
        s = "seg";
        if(s!=null)
        Log.d("mylogs",s);
        s =null;
        if(s!=null)
        Log.d("mylogs",s);
        s = "seg";
        if(s!=null)
        Log.d("mylogs",s);
        s = test1();
        if(s!=null){
            s =null;
            Log.d("mylogs",s);
        }
        if (s != null) {
            s =null;
            test3(s);
        }
    }
    @NonNull
    public String test1(){
        return "";
    }
    @Nullable
    public String test2(){
        return "";
    }
    public String test3(@NonNull String s){
        return "";
    }
    public String test4(@Nullable String s){
        return "";
    }
}
