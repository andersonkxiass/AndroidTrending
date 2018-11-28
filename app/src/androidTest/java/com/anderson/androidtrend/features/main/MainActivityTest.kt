package com.anderson.androidtrend.features.main

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.anderson.androidtrend.MockServerDispatcher
import com.anderson.androidtrend.R
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule  = ActivityTestRule(MainActivity::class.java)

    private lateinit var activity : MainActivity
    private val webServer : MockWebServer = MockWebServer()
    val context = InstrumentationRegistry.getInstrumentation().context!!

    @Before
    fun setUp() {
        webServer.start(8080)
        activity = activityRule.activity
    }

    @Test
    fun checkListView(){

        activityRule.launchActivity(Intent())

        onView(withId(R.id.project_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkProjectItemView_isDisplayed() {

        webServer.setDispatcher(MockServerDispatcher(context).RequestDispatcher())

        activityRule.launchActivity(Intent())

        onView(ViewMatchers.withId(R.id.project_list))
            .perform(RecyclerViewActions.scrollToPosition<ProjectAdapter.ViewHolder>(2))
    }

    @Test
    fun click_ProjectItem() {

        webServer.setDispatcher(MockServerDispatcher(context).RequestDispatcher())

        activityRule.launchActivity(Intent())

        onView(ViewMatchers.withId(R.id.project_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ProjectAdapter.ViewHolder>(
                    1,
                    click()
                )
            )

        onView(ViewMatchers.withId(R.id.contributors_list))
            .perform(RecyclerViewActions.scrollToPosition<ProjectAdapter.ViewHolder>(5))
    }

    @After
    fun tearDown() {
        webServer.shutdown()
    }
}