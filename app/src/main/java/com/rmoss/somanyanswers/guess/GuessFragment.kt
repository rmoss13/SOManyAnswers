package com.rmoss.somanyanswers.guess

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Answer
import com.rmoss.somanyanswers.model.Question
import kotlinx.android.synthetic.main.fragment_guess.*

class GuessFragment(private val question: Question) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: GuessRecyclerViewAdapter
    private lateinit var guessPresenter: GuessPresenter
    private var correctAnswer: Answer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerViewAdapter = GuessRecyclerViewAdapter(requireContext(), this)
        guessPresenter = GuessPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_guess, container, false)
        val guessTitle = view.findViewById<TextView>(R.id.guess_title)
        guessTitle.text = question.title
        recyclerView = view.findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerViewAdapter
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        guessPresenter.loadAnswers(question.id)
    }

    fun showResult(answer: Answer) {
        if(answer.isAccepted){
            updateResultText(R.string.correct_answer, ContextCompat.getColor(requireContext(), R.color.correct_answer_background))
        } else {
            updateResultText(R.string.wrong_answer, Color.RED)
            result_answer_text.visibility = View.VISIBLE
            result_answer_text.text = answer.body
        }
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun setAnswerList(answerList: List<Answer>) {
        correctAnswer = answerList.find { answer -> answer.isAccepted }
        recyclerViewAdapter.setAnswerList(answerList)
    }

    private fun updateResultText(string_id: Int, color_id: Int) {
        result_text.text = getString(string_id)
        result_text.setTextColor(color_id)
    }
}