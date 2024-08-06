package com.example.unittestingexample.utils

class emailVerifier (){

    fun isPasswordValid(password:String):Boolean{
        if(password.isEmpty()){
            return false;
        }

        if(password.length<6 || password.length>15){
            return false;
        }
        return true;
    }
}