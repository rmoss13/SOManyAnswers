package com.rmoss.somanyanswers.questionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Question

class QuestionListFragment : Fragment() {
    private val recyclerView get() = view as RecyclerView

    var questionList: List<Question> = emptyList()
        set(value) {
            field = value
            recyclerView.adapter =
                QuestionRecyclerViewAdapter(requireContext(), questionList)
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflateView<RecyclerView>(
        inflater, container,
        R.layout.fragment_question_list
    )
        .apply {
            layoutManager = LinearLayoutManager(context)
            adapter = QuestionRecyclerViewAdapter(context, questionList)
        }

    @Suppress("UNCHECKED_CAST")
    fun <T : View> inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        layout: Int
    ): T = inflater.inflate(layout, container, false) as T
}