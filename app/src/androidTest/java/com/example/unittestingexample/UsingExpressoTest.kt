package com.example.unittestingexample

import android.content.Intent
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.matcher.IntentMatchers.hasType
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class usingExpressoTest{

    @get:Rule
    val activityScenarioRule = activityScenarioRule<usingExpresso>()

    @Test
    fun test_incrementBtn(){

        onView(withId(R.id.incrementBtn)).perform(click())
        onView(withId(R.id.incrementBtn)).perform(click())
        onView(withId(R.id.incrementBtn)).perform(click())
        onView(withId(R.id.incrementBtn)).check(matches(withText("3")))
    }

    @Test
    fun test_shareBtn(){
        Intents.init()
        val expected = Matchers.allOf(
            IntentMatchers.hasAction(Intent.ACTION_SEND),
            IntentMatchers.hasType("text/plain")
        )
        onView(withId(R.id.shareBtn)).perform(click())
        intended(chooser(expected))
        Intents.release()
    }
    fun chooser(matcher: Matcher<Intent>): Matcher<Intent> {
        return allOf(
            hasAction(Intent.ACTION_CHOOSER),
            hasExtra(`is`(Intent.EXTRA_INTENT), matcher))
    }
}