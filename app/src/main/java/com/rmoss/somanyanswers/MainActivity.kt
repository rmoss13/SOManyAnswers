package com.rmoss.somanyanswers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rmoss.somanyanswers.guess.GuessFragment
import com.rmoss.somanyanswers.model.Question
import com.rmoss.somanyanswers.questionlist.QuestionListFragment
import com.rmoss.somanyanswers.questionlist.QuestionListPresenter

class MainActivity : AppCompatActivity() {


    private val questionListFragment = QuestionListFragment()
    private lateinit var questionListPresenter: QuestionListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, questionListFragment)
        fragmentTransaction.commit()

        questionListPresenter = QuestionListPresenter(questionListFragment)
        questionListPresenter.loadQuestions()
    }

    fun openGuessFragment(question: Question) {
        supportFragmentManager.beginTransaction()
            .addToBackStack("")
            .replace(R.id.fragment_container, GuessFragment(question))
            .commit()
    }
}