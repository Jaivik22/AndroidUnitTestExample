package com.example.unittestingexample

import android.content.Context
import com.google.gson.Gson

class quotesManager() {

    var quoteList = emptyArray<Quote>()
    var currenQuoteIndex = 0;

    fun populateQuoteFromAssets(context: Context,filename:String){
        val inputStream = context.assets.open(filename)
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()

        quoteList = gson.fromJson(json,Array<Quote>::class.java)
    }
    fun populateQuotes(quotes:Array<Quote>){
        quoteList = quotes
    }
    fun getCurrentQuote():Quote{
        return quoteList[currenQuoteIndex]
    }
    fun getNextQuote():Quote{
        if(currenQuoteIndex==quoteList.size-1) return quoteList[currenQuoteIndex]
        return quoteList[++currenQuoteIndex]
    }
    fun getPreviousQuote():Quote{
        if(currenQuoteIndex==0) return quoteList[currenQuoteIndex]
        return quoteList[--currenQuoteIndex]
    }
}