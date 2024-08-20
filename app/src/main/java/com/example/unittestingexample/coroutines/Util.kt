package com.example.unittestingexample.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Util(val dispatcher: CoroutineDispatcher){
    suspend fun getUserName():String{
        delay(10000)
        return "Jaivik"
    }

    suspend fun getUser():String{
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "Jaivik Kotadiya"
    }
    suspend fun getAddress():String{
        CoroutineScope(dispatcher).launch {
            delay(2000)
        }
        return "Palanpur"
    }

    var flag = false
    suspend fun getAddressName(){
        CoroutineScope(dispatcher).launch {
            flag = true
        }
    }


}