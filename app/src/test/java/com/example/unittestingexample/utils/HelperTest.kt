package com.example.unittestingexample.utils

import org.junit.Assert.*

import org.junit.Test

class HelperTest {

    @Test
    fun isPalindrome() {
        //Arrange
        val helper = Helper()

        //Act
        val result = helper.isPalindrome("aba")

        //Assert
        assertEquals(true,result);
    }
}