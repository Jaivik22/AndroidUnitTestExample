package com.example.unittestingexample.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UtilTest {


   @get:Rule
   val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun getUserName() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest { sut.getUserName() }

    }
    @Test
    fun getUserTest(){
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest { sut.getUser()
        sut.getAddress()}
    }
    @Test
    fun getAddressNameTest(){
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddressName()
            //Test dispacher has leave coroutine handling on us, so we have to decide whether we want to exeute coroutine or not
            // Whenever we launch couroutine it adds in queue in schedular  and will not execute so we have to tell hime to
            //execute coroutine
            //So if you we do not add below line your test case will fail
            // below line will tell scheduler to execute every coroutine and then execute assert line
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals(true,sut.flag)
        }
    }
}