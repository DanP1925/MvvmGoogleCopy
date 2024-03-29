package com.example.examplemvvm.tasks

import android.view.Gravity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.open
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.DrawerMatchers.isOpen
import androidx.test.espresso.contrib.NavigationViewActions.navigateTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.examplemvvm.R
import com.example.examplemvvm.getToolbarNavigationContentDescription
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class AppNavigationTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(TasksActivity::class.java)

    @Test
    fun clickOnStatisticsNavigationItem_ShowStatisticsScreen() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.START)))
                .perform(open())

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.statistics_navigation_menu_item))

        onView(withId(R.id.statistics))
                .check(matches(isDisplayed()))
    }

    @Test
    fun clickOnListNavigationItem_ShowsListScreen() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.START)))
                .perform(open())

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.statistics_navigation_menu_item))

        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.START)))
                .perform(open())

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.list_navigation_menu_item))

        onView(withId(R.id.tasksContainer)).check(matches(isDisplayed()))
    }

    @Test
    fun clickOnAndroidHomeIcon_OpensNavigation(){

        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.START)))

        onView(
                withContentDescription(
                        activityTestRule.activity.getToolbarNavigationContentDescription(R.id.toolbar)
                )
        ).perform(click())

        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen(Gravity.START)))
    }

}