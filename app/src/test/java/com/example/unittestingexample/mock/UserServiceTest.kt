package com.example.unittestingexample.mock

import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_USER)
    }

    @Test
    fun testUserService(){
        val sut = UserService(userRepository)
        val status = sut.loginUser("thisisjaivik@gmail.com","jaivik0123")
        Assert.assertEquals("User does not exits",status)
    }

    @After
    fun tearDown() {
    }
}