package com.rmoss.somanyanswers.questionlist

import com.rmoss.somanyanswers.model.Question

interface QuestionListContract {

    interface View {
        fun showProgress()

        fun hideProgress()

        fun showQuestionList(questions: MutableList<Question>)

        fun showLoadingError()
    }

    interface Presenter {
        fun loadQuestionList()
    }

    interface OnResponseCallback {
        fun onResponse(questions: MutableList<Question>)

        fun onError()
    }
}