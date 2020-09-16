package com.rmoss.somanyanswers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.rmoss.somanyanswers.guess.GuessFragment
import com.rmoss.somanyanswers.model.Question
import com.rmoss.somanyanswers.questionlist.QuestionListFragment
import com.rmoss.somanyanswers.questionlist.QuestionListPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val questionListFragment = QuestionListFragment()
    private lateinit var questionListPresenter: QuestionListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        questionListPresenter = QuestionListPresenter(questionListFragment)
        fragmentTransaction.add(R.id.fragment_container, questionListFragment)
        fragmentTransaction.commit()
    }

    fun openGuessFragment(question: Question) {
        supportFragmentManager.beginTransaction()
            .addToBackStack("")
            .replace(R.id.fragment_container, GuessFragment(question))
            .commit()
    }

    fun showNoQuestionsFound() {
        no_questions_found_view.visibility = View.VISIBLE
    }

    companion object MainActivity {
        @Suppress("UNCHECKED_CAST")
        fun <T : View> inflateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            layout: Int
        ): T = inflater.inflate(layout, container, false) as T
    }
}