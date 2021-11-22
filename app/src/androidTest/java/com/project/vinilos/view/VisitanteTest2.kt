package com.project.vinilos.view


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.project.vinilos.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class VisitanteTest2 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun visitanteTest2() {
        val textView = onView(
            allOf(
                withId(R.id.textView), withText("Vinilos App"),
                withParent(
                    allOf(
                        withId(R.id.viewRoot),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Vinilos App")))

        val imageView = onView(
            allOf(
                withId(R.id.dice_image), withContentDescription("Logo"),
                withParent(
                    allOf(
                        withId(R.id.viewRoot),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val button = onView(
            allOf(
                withId(R.id.visitor_button), withText("Visitante"),
                withParent(withParent(withId(R.id.viewRoot))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val materialButton = onView(
            allOf(
                withId(R.id.visitor_button), withText("Visitante"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.viewRoot),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

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

        val imageView2 = onView(
            allOf(
                withContentDescription("More options"),
                withParent(withParent(withId(R.id.toolbar))),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val textView3 = onView(
            allOf(
                withId(R.id.tvAlbumTitle), withText("Albumes"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Albumes")))

        val imageView3 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_collecotrs), withContentDescription("Coleccionistas"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(R.id.navigation_bar_item_large_label_view), withText("Coleccionistas"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.ic_collecotrs),
                                withContentDescription("Coleccionistas")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Coleccionistas")))

        val imageView4 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_artists), withContentDescription("Artistas"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView4.check(matches(isDisplayed()))

        val textView5 = onView(
            allOf(
                withId(R.id.navigation_bar_item_small_label_view), withText("Artistas"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.ic_artists),
                                withContentDescription("Artistas")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("Artistas")))

        val imageView5 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_albums), withContentDescription("Albumes"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView5.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                withId(R.id.navigation_bar_item_small_label_view), withText("Albumes"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(allOf(withId(R.id.ic_albums), withContentDescription("Albumes")))
                    )
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("Albumes")))

        val recyclerView = onView(
            allOf(
                withId(R.id.rvAlbums),
                childAtPosition(
                    withClassName(`is`("android.widget.FrameLayout")),
                    2
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val imageButton2 = onView(
            allOf(
                withContentDescription("Navigate up"),
                withParent(
                    allOf(
                        withId(R.id.toolbar),
                        withParent(withId(R.id.toolbar_layout))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton2.check(matches(isDisplayed()))

        val imageView6 = onView(
            allOf(
                withId(R.id.bgAlbumImage),
                withParent(
                    allOf(
                        withId(R.id.toolbar_layout),
                        withParent(withId(R.id.app_bar))
                    )
                ),
                isDisplayed()
            )
        )
        imageView6.check(matches(isDisplayed()))

        val imageView7 = onView(
            allOf(
                withContentDescription("More options"),
                withParent(withParent(withId(R.id.toolbar))),
                isDisplayed()
            )
        )
        imageView7.check(matches(isDisplayed()))

        val textView7 = onView(
            allOf(
                withId(R.id.tvAlbumDetailsTitle), withText("Buscando Am�rica"),
                withParent(withParent(withId(R.id.scTracksList))),
                isDisplayed()
            )
        )
        textView7.check(matches(isDisplayed()))

        val textView8 = onView(
            allOf(
                withId(R.id.tvAlbumDetailsArtist), withText("Elektra"),
                withParent(withParent(withId(R.id.scTracksList))),
                isDisplayed()
            )
        )
        textView8.check(matches(isDisplayed()))

        val textView9 = onView(
            allOf(
                withId(R.id.tvAlbumDetailsDescription),
                withText("Buscando Am�rica es el primer �lbum de la banda de Rub�n Blades y Seis del Solar lanzado en 1984. La producci�n, bajo el sello Elektra, fusiona diferentes ritmos musicales tales como la salsa, reggae, rock, y el jazz latino. El disco fue grabado en Eurosound Studios en Nueva York entre mayo y agosto de 1983."),
                withParent(withParent(withId(R.id.scTracksList))),
                isDisplayed()
            )
        )
        textView9.check(matches(isDisplayed()))

        val imageView8 = onView(
            allOf(
                withId(R.id.ivAlbumCover), withContentDescription("run"),
                withParent(
                    allOf(
                        withId(R.id.lyTrackItem),
                        withParent(withId(R.id.rvTracks))
                    )
                ),
                isDisplayed()
            )
        )
        imageView8.check(matches(isDisplayed()))

        val textView10 = onView(
            allOf(
                withId(R.id.tvTrackTitle), withText("Decisiones"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        textView10.check(matches(isDisplayed()))

        val textView11 = onView(
            allOf(
                withId(R.id.tvTrackArtist), withText("Rub�n Blades Bellido de Luna"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        textView11.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(
                withId(R.id.collector_button), withText("Agregar Canciones"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))

        val imageView9 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_collecotrs), withContentDescription("Coleccionistas"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView9.check(matches(isDisplayed()))

        val textView12 = onView(
            allOf(
                withId(R.id.navigation_bar_item_large_label_view), withText("Coleccionistas"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.ic_collecotrs),
                                withContentDescription("Coleccionistas")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView12.check(matches(withText("Coleccionistas")))

        val imageView10 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_artists), withContentDescription("Artistas"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView10.check(matches(isDisplayed()))

        val textView13 = onView(
            allOf(
                withId(R.id.navigation_bar_item_small_label_view), withText("Artistas"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.ic_artists),
                                withContentDescription("Artistas")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView13.check(matches(withText("Artistas")))

        val imageView11 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_albums), withContentDescription("Albumes"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView11.check(matches(isDisplayed()))

        val textView14 = onView(
            allOf(
                withId(R.id.navigation_bar_item_small_label_view), withText("Albumes"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(allOf(withId(R.id.ic_albums), withContentDescription("Albumes")))
                    )
                ),
                isDisplayed()
            )
        )
        textView14.check(matches(withText("Albumes")))

        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Navigate up"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withId(R.id.toolbar_layout),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.ic_collecotrs), withContentDescription("Coleccionistas"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val imageButton3 = onView(
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
        imageButton3.check(matches(isDisplayed()))

        val textView15 = onView(
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
        textView15.check(matches(withText("Vinilos App")))

        val imageView12 = onView(
            allOf(
                withContentDescription("More options"),
                withParent(withParent(withId(R.id.toolbar))),
                isDisplayed()
            )
        )
        imageView12.check(matches(isDisplayed()))

        val textView16 = onView(
            allOf(
                withId(R.id.tvCollectorTitle), withText("Coleccionistas"),
                withParent(
                    allOf(
                        withId(R.id.FrameLayout),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        textView16.check(matches(withText("Coleccionistas")))

        val imageView13 = onView(
            allOf(
                withId(R.id.ivCollectorCover),
                withParent(
                    allOf(
                        withId(R.id.lyCollectorItem),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView13.check(matches(isDisplayed()))

        val imageView14 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_collecotrs), withContentDescription("Coleccionistas"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView14.check(matches(isDisplayed()))

        val textView17 = onView(
            allOf(
                withId(R.id.navigation_bar_item_large_label_view), withText("Coleccionistas"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.ic_collecotrs),
                                withContentDescription("Coleccionistas")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView17.check(matches(withText("Coleccionistas")))

        val imageView15 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_artists), withContentDescription("Artistas"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView15.check(matches(isDisplayed()))

        val textView18 = onView(
            allOf(
                withId(R.id.navigation_bar_item_small_label_view), withText("Artistas"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.ic_artists),
                                withContentDescription("Artistas")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView18.check(matches(withText("Artistas")))

        val imageView16 = onView(
            allOf(
                withId(R.id.navigation_bar_item_icon_view),
                withParent(
                    allOf(
                        withId(R.id.ic_albums), withContentDescription("Albumes"),
                        withParent(IsInstanceOf.instanceOf(android.view.View::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView16.check(matches(isDisplayed()))

        val textView19 = onView(
            allOf(
                withId(R.id.navigation_bar_item_small_label_view), withText("Albumes"),
                withParent(
                    allOf(
                        withId(R.id.navigation_bar_item_labels_group),
                        withParent(allOf(withId(R.id.ic_albums), withContentDescription("Albumes")))
                    )
                ),
                isDisplayed()
            )
        )
        textView19.check(matches(withText("Albumes")))

        val appCompatImageButton2 = onView(
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
        appCompatImageButton2.perform(click())

        pressBack()

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.ic_artists), withContentDescription("Artistas"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

        val bottomNavigationItemView3 = onView(
            allOf(
                withId(R.id.ic_artists), withContentDescription("Artistas"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView3.perform(click())

        val appCompatImageButton3 = onView(
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
        appCompatImageButton3.perform(click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.visitor_button), withText("Visitante"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.viewRoot),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val bottomNavigationItemView4 = onView(
            allOf(
                withId(R.id.ic_albums), withContentDescription("Albumes"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView4.perform(click())

        val bottomNavigationItemView5 = onView(
            allOf(
                withId(R.id.ic_albums), withContentDescription("Albumes"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView5.perform(click())

        val appCompatImageButton4 = onView(
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
        appCompatImageButton4.perform(click())

        val materialButton3 = onView(
            allOf(
                withId(R.id.visitor_button), withText("Visitante"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.viewRoot),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton3.perform(click())

        val bottomNavigationItemView6 = onView(
            allOf(
                withId(R.id.ic_collecotrs), withContentDescription("Coleccionistas"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView6.perform(click())

        val bottomNavigationItemView7 = onView(
            allOf(
                withId(R.id.ic_artists), withContentDescription("Artistas"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView7.perform(click())

        val bottomNavigationItemView8 = onView(
            allOf(
                withId(R.id.ic_albums), withContentDescription("Albumes"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView8.perform(click())

        val bottomNavigationItemView9 = onView(
            allOf(
                withId(R.id.ic_albums), withContentDescription("Albumes"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.button_footer_navigation),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView9.perform(click())

        val appCompatImageButton5 = onView(
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
        appCompatImageButton5.perform(click())
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
