package com.example.unittestingexample.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class emailVerifierTest {

    @Test
    fun isPasswordValid_password_empty() {
        val ev = emailVerifier();
        val result  = ev.isPasswordValid("")
        assertEquals(false,result);
    }

    @Test
    fun isPasswordValid_password_is_smaller() {
        val ev = emailVerifier();
        val result  = ev.isPasswordValid("abcde")
        assertEquals(false,result);
    }
    @Test
    fun isPasswordValid_password_is_longer() {
        val ev = emailVerifier();
        val result  = ev.isPasswordValid("jaivikRameshbhaiKotadiya")
        assertEquals(false,result);
    }



    @Test
    fun isPasswordValid_password_correct_format() {
        val ev = emailVerifier();
        val result  = ev.isPasswordValid("jaivikKotadiya")
        assertEquals(true,result);
    }
}