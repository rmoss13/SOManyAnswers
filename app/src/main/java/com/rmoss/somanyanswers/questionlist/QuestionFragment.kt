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

class QuestionFragment : Fragment(), QuestionListContract.View {

    private val questionRecyclerViewAdapter = QuestionRecyclerViewAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question_list, container, false) as RecyclerView

        with(view) {
            layoutManager = LinearLayoutManager(context)
            adapter = questionRecyclerViewAdapter
        }
        val presenter = QuestionPresenter(this, FakeQuestionRepository())
        presenter.loadQuestionList()

        return view
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showQuestionList(questions: MutableList<Question>) {
        questionRecyclerViewAdapter.setQuestionList(questions)
    }

    override fun showLoadingError() {
        TODO("Not yet implemented")
    }
}