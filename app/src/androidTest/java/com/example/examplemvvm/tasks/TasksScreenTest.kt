package com.example.examplemvvm.tasks

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.examplemvvm.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TasksScreenTest{

    @Rule @JvmField var tasksActivityTestRule =
            ActivityTestRule<TasksActivity>(TasksActivity::class.java)


    @Test
    fun clickAddTaskButton_opensAddTaskUi(){
        onView(withId(R.id.fab_add_task)).perform(click())

/*        onView(withId(R.id.add_task_title)).check(matches(isDisplayed()))*/
    }

}