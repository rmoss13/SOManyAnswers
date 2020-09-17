package com.rmoss.somanyanswers.guess

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Answer

class AnswerRecyclerViewAdapter(private var context: Context) : RecyclerView.Adapter<AnswerRecyclerViewAdapter.ViewHolder>()  {

    private var answers: List<Answer> = emptyList()

    fun setAnswerList(answerList: List<Answer>) {
        answers = answerList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_answer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val answer = answers[position]
        with(viewHolder) {
            body.text = answer.body
            viewHolder.container.setOnClickListener{
                //TODO
            }
        }
    }

    override fun getItemCount(): Int = answers.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.answer_container)
        val body: TextView = view.findViewById(R.id.answer_body)
    }
}