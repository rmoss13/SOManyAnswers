package com.rmoss.somanyanswers.questionlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Question


class QuestionRecyclerViewAdapter : RecyclerView.Adapter<QuestionRecyclerViewAdapter.QuestionRecyclerViewHolder>() {

    private var questions: List<Question> = emptyList()

    fun setQuestionList(questionList: MutableList<Question>) {
        questions = questionList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_question, parent, false)
        return QuestionRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: QuestionRecyclerViewHolder, position: Int) {
        val item = questions[position]
        viewHolder.titleView.text = item.title
    }

    override fun getItemCount(): Int = questions.size

    inner class QuestionRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.question_title)
    }
}