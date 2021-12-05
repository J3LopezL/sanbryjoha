package com.project.vinilos.view.pruebas

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.project.vinilos.R
import com.project.vinilos.view.CollectorListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CollectorListActivityTest{

    @get:Rule
    val activityRule : ActivityScenarioRule<CollectorListActivity> = ActivityScenarioRule(
        CollectorListActivity::class.java)

    @Test
    fun colecctorTest() {
        Espresso.onView(ViewMatchers.withId(R.id.collectorList))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun titleTest() {
        Espresso.onView(ViewMatchers.withId(R.id.tvCollectorTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.collectors)))
    }

    @Test
    fun bottomNavigationFooterTest() {
        Espresso.onView(ViewMatchers.withId(R.id.button_footer_navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}