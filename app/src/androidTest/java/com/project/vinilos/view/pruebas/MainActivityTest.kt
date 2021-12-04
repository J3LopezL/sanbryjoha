package com.project.vinilos.view.unit

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.project.vinilos.R
import com.project.vinilos.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testActivityMain() {
        Espresso.onView(ViewMatchers.withId(R.id.viewRoot))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testImage() {
        Espresso.onView(ViewMatchers.withId(R.id.dice_image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testButtonCollections() {
        Espresso.onView(ViewMatchers.withId(R.id.collector_button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testButtonVisitant() {
        Espresso.onView(ViewMatchers.withId(R.id.visitor_button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testTitle() {
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Vinilos App")))
    }

    @Test
    fun testClickButtonCollections() {
        Espresso.onView(ViewMatchers.withId(R.id.collector_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.albumsListActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testClickButtonVisitant() {
        Espresso.onView(ViewMatchers.withId(R.id.visitor_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.albumsListActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}