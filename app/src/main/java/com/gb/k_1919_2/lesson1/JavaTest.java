package com.gb.k_1919_2.lesson1;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class JavaTest   {
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
