package com.example.unittestingexample.utils

class PalindromeChecker {

    fun  isPalindrome(s:String):Boolean{
        val reverse = s.substring(0).reversed()
        if(reverse.equals(s)){
            return true;
        }
        return false
    }
}