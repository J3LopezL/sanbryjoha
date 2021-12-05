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
import com.project.vinilos.view.AlbumsListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class AlbumsListActivityTest{

    @get:Rule
    val activityScenario : ActivityScenarioRule<AlbumsListActivity> = ActivityScenarioRule(
        AlbumsListActivity::class.java)

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(AlbumsListActivity::class.java)

    @Test
    fun albumListTest() {
        Espresso.onView(ViewMatchers.withId(R.id.albumsListActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun titleAlbumsTest() {
        Espresso.onView(ViewMatchers.withId(R.id.tvAlbumTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText("Albumes")))
    }

    @Test
    fun albumsDisplayRecyclerViewTest() {
        Espresso.onView(ViewMatchers.withId(R.id.rvAlbums))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun albumsScrollRecyclerViewTest(){
        val recyclerView : RecyclerView = activityRule.activity.findViewById(R.id.rvAlbums)
        val itemcount = recyclerView.adapter?.itemCount

        if(itemcount != null){
            Espresso.onView(ViewMatchers.withId(R.id.rvAlbums))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemcount.minus(1)))
        }
    }

    @Test
    fun albumShowDetailsFromRecyclerViewItemTest(){
        val recyclerView : RecyclerView = activityRule.activity.findViewById(R.id.rvAlbums)
        val itemSelect = recyclerView.adapter?.itemCount
        Log.i("Hay", itemSelect.toString())

        if(itemSelect != null)
        {
            Espresso.onView(ViewMatchers.withId(R.id.rvAlbums))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView
                    .ViewHolder>(0, ViewActions.click()))
            Espresso.onView(ViewMatchers.withId(R.id.albumDetail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun buttonNewAlbum() {
        Espresso.onView(ViewMatchers.withId(R.id.newAlbum))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun albumCreateNewTest(){
        Espresso.onView(ViewMatchers.withId(R.id.newAlbum)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.scrollView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun albumButtonFooterTest(){
        Espresso.onView(ViewMatchers.withId(R.id.button_footer_navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}