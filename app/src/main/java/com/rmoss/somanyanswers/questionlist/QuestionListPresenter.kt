package com.rmoss.somanyanswers.questionlist

import com.rmoss.somanyanswers.MainActivity
import com.rmoss.somanyanswers.QuestionService
import com.rmoss.somanyanswers.StackOverflowQuestionService
import com.rmoss.somanyanswers.model.Question

class QuestionListPresenter(private val questionListFragment: QuestionListFragment) {
    private val questionService: QuestionService
    private val callback: QuestionService.OnResponseCallback = object :
        QuestionService.OnResponseCallback {

        override fun onResponse(questions: MutableList<Question>) {
            questionListFragment.questionList = questions
        }

        override fun onError() {
            (questionListFragment.activity as MainActivity).showNoQuestionsFound()
        }
    }

    init {
        questionService = StackOverflowQuestionService(callback)
    }
}