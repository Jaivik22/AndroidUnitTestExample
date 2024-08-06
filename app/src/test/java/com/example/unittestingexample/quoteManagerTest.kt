package com.example.unittestingexample

import android.content.Context
import android.content.res.AssetManager
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn

// We have already tested this class using instrumentation test
// We have used instrumentation test to test this class because we needed context
// of the application to access the file (here: val inputStream = context.assets.open(filename))
// Now we will test this class by mocking our context
// As our priority is that our maximum test should be JVM tests
class quoteManagerTest {

    @Mock
    lateinit var context:Context

    @Mock
    lateinit var assetManager : AssetManager

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test(){
        //As we can not use quotes file from json because we can't use context so to mock we have added
        //quotes.json in UnitTestingExample\app\src\test\resources for testing
        val testStream = quotesManager::class.java.getResourceAsStream("/quotes.json")
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val sut = quotesManager()
        sut.populateQuoteFromAssets(context,"")
        val quote = sut.getCurrentQuote()
        Assert.assertEquals("The only thing we have to fear is fear itself.",quote.quote)
    }
}