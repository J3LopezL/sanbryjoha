package com.project.vinilos.view.pruebas

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.project.vinilos.R
import com.project.vinilos.view.PerformersListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class PerformersListActivityTest{

    @get: Rule
    val activityScenario : ActivityScenarioRule<PerformersListActivity> = ActivityScenarioRule(
        PerformersListActivity::class.java)

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(PerformersListActivity::class.java)

    @Test
    fun performerDisplayActivityTest() {
        Espresso.onView(ViewMatchers.withId(R.id.performerList))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun performerDisplayTitleTest() {
        Espresso.onView(ViewMatchers.withId(R.id.tvPerformerTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.performers)))
    }

    @Test
    fun performerDisplayRecyclerViewTest() {
        Espresso.onView(ViewMatchers.withId(R.id.rvPerformers))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun performerScrollRecyclerViewTest(){
        val recyclerView : RecyclerView = activityRule.activity.findViewById(R.id.rvPerformers)
        val itemcount = recyclerView.adapter?.itemCount

        if(itemcount != null)
        {
            Espresso.onView(ViewMatchers.withId(R.id.rvPerformers))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemcount.minus(1)))
        }
    }

    @Test
    fun performerShowDetailsFromRecyclerViewItemTest(){
        val recyclerView : RecyclerView = activityRule.activity.findViewById(R.id.rvPerformers)
        val itemscount = recyclerView.adapter?.itemCount
        Log.i("Items", itemscount.toString())

        if(itemscount != null)
        {
            Espresso.onView(ViewMatchers.withId(R.id.rvPerformers))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView
                .ViewHolder>(0, ViewActions.click()))
            Espresso.onView(ViewMatchers.withId(R.id.performerDetail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }
}