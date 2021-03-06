package com.rmoss.somanyanswers.questionlist

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Question
import org.junit.Before
import org.junit.Test

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

    @Test
    fun canBeUpdatedWithPopulatedList() {
        val questionList: List<Question> = listOf(
            Question(1, "Question 1", "This is a body1", true, 2, emptyList(), 0),
            Question(2, "Question 2","This is a body2", true, 2, emptyList(), 0)
        )

        scenario.onFragment { it.questionList = questionList }
        onView(withId(R.id.list)).check(matches(hasChildCount(questionList.size)))
    }
}