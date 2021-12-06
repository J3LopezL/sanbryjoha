package com.project.vinilos.view


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.project.vinilos.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ColeccionistaTest  {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun coleccionistaTest() {
        val textView = onView(
            allOf(
                withId(R.id.textView), withText("Vinilos App"),
                withParent(withParent(withId(R.id.viewRoot))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Vinilos App")))

        val imageView = onView(
            allOf(
                withId(R.id.dice_image),
                withParent(withParent(withId(R.id.viewRoot))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val button = onView(
            allOf(
                withId(R.id.collector_button), withText("Coleccionista"),
                withParent(withParent(withId(R.id.viewRoot))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val materialButton = onView(
            allOf(
                withId(R.id.collector_button), withText("Coleccionista"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.viewRoot),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val textView2 = onView(
            allOf(
                withText("Vinilos App"),
                withParent(
                    allOf(
                        withId(R.id.toolbar),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Vinilos App")))

        val view = onView(
            allOf(
                withId(R.id.toolbar),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        view.check(matches(isDisplayed()))

        val imageButton = onView(
            allOf(
                withContentDescription("Navigate up"),
                withParent(
                    allOf(
                        withId(R.id.toolbar),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton.check(matches(isDisplayed()))

        val imageView2 = onView(
            allOf(
                withContentDescription("More options"),
                withParent(withParent(withId(R.id.toolbar))),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val view2 = onView(
            allOf(
                withId(R.id.rvAlbums),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        view2.check(matches(isDisplayed()))

        val textView3 = onView(
            allOf(
                withId(R.id.tvAlbumTitle), withText("Albumes"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Albumes")))

        val imageView6 = onView(
            allOf(
                withContentDescription("More options"),
                withParent(withParent(withId(R.id.toolbar))),
                isDisplayed()
            )
        )
        imageView6.check(matches(isDisplayed()))

        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Navigate up"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("com.google.android.material.appbar.AppBarLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
