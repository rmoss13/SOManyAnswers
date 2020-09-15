package com.rmoss.somanyanswers.question_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R


class QuestionRecyclerViewAdapter(private val values: List<Question>) : RecyclerView.Adapter<QuestionRecyclerViewAdapter.QuestionRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_question, parent, false)
        return QuestionRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: QuestionRecyclerViewHolder, position: Int) {
        val item = values[position]
        viewHolder.titleView.text = item.title
    }

    override fun getItemCount(): Int = values.size

    inner class QuestionRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.question_title)
    }
}