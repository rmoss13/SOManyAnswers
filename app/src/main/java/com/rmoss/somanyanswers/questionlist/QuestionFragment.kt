package com.rmoss.somanyanswers.question_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R

class QuestionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question_list, container, false) as RecyclerView

        with(view) {
            layoutManager = LinearLayoutManager(context)
            adapter =
                QuestionRecyclerViewAdapter(
                    Question.ITEMS
                )
        }
        return view
    }
}