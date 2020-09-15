package com.rmoss.somanyanswers.questionlist

interface QuestionRepository {
    fun getQuestionList(callback: QuestionListContract.OnResponseCallback)
}