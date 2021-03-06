package com.rmoss.somanyanswers.guess

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.rmoss.somanyanswers.R
import com.rmoss.somanyanswers.model.Answer

class GuessRecyclerViewAdapter(
    private var context: Context,
    private val guessFragment: GuessFragment
) : RecyclerView.Adapter<GuessRecyclerViewAdapter.ViewHolder>() {

    private var answers: List<Answer> = emptyList()
    private var answerSelected = false

    override fun getItemCount(): Int = answers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_answer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val answer = answers[position]
        with(viewHolder) {
            body.text = answer.body
            viewHolder.container.setOnClickListener {
                if (!answerSelected) {
                    answerSelected = true
                    showSelectedAnswer(viewHolder)
                    guessFragment.showResult(answer)
                }
            }
        }
    }

    fun setAnswerList(answerList: List<Answer>) {
        answers = answerList
        notifyDataSetChanged()
    }

    private fun showSelectedAnswer(viewHolder: ViewHolder) {
        viewHolder.apply {
            container.setBackgroundColor(
                getColorWith(R.color.selected_background)
            )
            body.setTextColor(
                getColorWith(R.color.selected_text)
            )
        }
    }

    private fun getColorWith(color_id: Int): Int {
        return ContextCompat.getColor(
            context,
            color_id
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: View = view.findViewById(R.id.answer_container)
        val body: TextView = view.findViewById(R.id.answer_body)
    }
}