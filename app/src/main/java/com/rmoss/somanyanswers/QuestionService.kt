package com.rmoss.somanyanswers

import com.rmoss.somanyanswers.model.Question

interface QuestionService {
    fun loadQuestionList()

    interface OnResponseCallback {
        fun onResponse(questions: MutableList<Question>)

        fun onError()
    }
}
