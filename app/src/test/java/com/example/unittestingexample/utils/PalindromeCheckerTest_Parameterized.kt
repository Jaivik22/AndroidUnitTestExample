package com.example.unittestingexample.utils

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class PalindromeCheckerTest_Parameterized(val input:String,val expectedValue:Boolean){

    @Test
    fun test(){
        val palindromeChecker = PalindromeChecker();
        val result = palindromeChecker.isPalindrome(input)
        assertEquals(expectedValue,result)
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data():List<Array<Any>>{
            return listOf(
                arrayOf("aba",true),
                arrayOf("jaivik",false),
                arrayOf("nayan",true),
                arrayOf("kotadiya",false)
            )
        }
    }
}