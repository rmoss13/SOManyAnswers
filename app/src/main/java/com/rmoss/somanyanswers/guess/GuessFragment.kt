package com.rmoss.somanyanswers.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Question

class GuessFragment(private val question: Question) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: AnswerRecyclerViewAdapter
    private lateinit var guessPresenter: GuessPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerViewAdapter = AnswerRecyclerViewAdapter(requireContext())
        guessPresenter = GuessPresenter(recyclerViewAdapter)
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
}