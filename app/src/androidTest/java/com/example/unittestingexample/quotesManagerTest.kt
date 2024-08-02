package com.example.unittestingexample

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class quotesManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        val quotesManager = quotesManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuoteFromAssets(context,"");
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateQuoteFromAssets_invalidJSON_Expected_Exception() {
        val quotesManager = quotesManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuoteFromAssets(context,"malform.json");

    }
    @Test
    fun populateQuoteFromAssets_invalidJSON_Expected_Count() {
        val quotesManager = quotesManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuoteFromAssets(context,"quotes.json");
        assertEquals(10,quotesManager.quoteList.size)
    }
    @Test
    fun testPreviousQuote_expeted_CorrectQuote() {
        //arrange
        val quotesManager = quotesManager()
        quotesManager.populateQuotes(arrayOf(
            Quote("This is first quote","1"),
            Quote("This is second quote","2"),
            Quote("This is third quote","3"),
        ))
        //Act
        val quote = quotesManager.getPreviousQuote()
        //Assert
        assertEquals("1",quote.author)
    }
}