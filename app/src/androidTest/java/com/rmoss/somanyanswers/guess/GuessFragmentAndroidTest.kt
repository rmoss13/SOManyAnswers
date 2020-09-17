package com.rmoss.somanyanswers.guess

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Answer
import org.junit.Before
import org.junit.Test

class GuessFragmentAndroidTest {

    private lateinit var scenario: FragmentScenario<GuessFragment>

    @Before
    fun setUp() {
        val fragmentArgs = Bundle()
        scenario = launchFragmentInContainer<GuessFragment>(fragmentArgs)
    }

    @Test
    fun startsWithEmptyList() {
        onView(withId(R.id.list)).check(matches(hasChildCount(0)))
    }

    @Test
    fun canBeUpdatedWithPopulatedList() {
        val answerList: List<Answer> = listOf(
            Answer(1, "Answer body 1", true),
            Answer(2, "Answer body 2", false),
            Answer(3, "Answer body 3", false)
        )

        scenario.onFragment { it.setAnswerList(answerList) }
        onView(withId(R.id.list)).check(matches(hasChildCount(answerList.size)))
    }
}