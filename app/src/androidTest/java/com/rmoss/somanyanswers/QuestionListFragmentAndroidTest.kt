package com.rmoss.somanyanswers

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.rmoss.somanyanswers.questionlist.QuestionListFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class QuestionListFragmentAndroidTest {

    private lateinit var scenario: FragmentScenario<QuestionListFragment>

    @Before
    fun setUp() {
        val fragmentArgs = Bundle()
        scenario = launchFragmentInContainer<QuestionListFragment>(fragmentArgs)
    }

    @Test
    fun startsWithEmptyList() {
        onView(withId(R.id.list)).check(matches(hasChildCount(0)))
    }
}