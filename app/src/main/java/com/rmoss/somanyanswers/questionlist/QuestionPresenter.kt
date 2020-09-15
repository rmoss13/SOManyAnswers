package com.rmoss.somanyanswers.questionlist

import android.graphics.Movie
import com.rmoss.somanyanswers.model.Question

import com.rmoss.somanyanswers.questionlist.QuestionListContract.OnResponseCallback




class QuestionPresenter(private val view: QuestionListContract.View, private val questionRepository: QuestionRepository): QuestionListContract.Presenter {
    override fun loadQuestionList() {
        questionRepository.getQuestionList(callback)
    }

    private val callback: OnResponseCallback = object : OnResponseCallback {
        override fun onResponse(questions: MutableList<Question>) {
            view.showQuestionList(questions)
        }

        override fun onError() {
            view.showLoadingError()
        }
    }
}