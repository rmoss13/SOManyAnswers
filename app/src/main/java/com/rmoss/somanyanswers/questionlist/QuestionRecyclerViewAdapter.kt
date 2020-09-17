package com.rmoss.somanyanswers.questionlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.MainActivity
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Question


class QuestionRecyclerViewAdapter(
    private var context: Context,
    private var questions: List<Question>
) : RecyclerView.Adapter<QuestionRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val question = questions[position]
        with(viewHolder) {
            titleView.text = question.title
            container.setOnClickListener {
                (context as MainActivity).openGuessFragment(question)
            }
        }
    }

    override fun getItemCount(): Int = questions.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.question_container)
        val titleView: TextView = view.findViewById(R.id.question_title)
    }
}