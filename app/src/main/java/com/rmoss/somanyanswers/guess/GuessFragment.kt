package com.rmoss.somanyanswers.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.MainActivity.MainActivity.inflateView
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Question

class GuessFragment(private val question: Question): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflateView<RecyclerView>(
        inflater, container,
        R.layout.fragment_question_list
    )
}