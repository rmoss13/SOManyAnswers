package com.rmoss.somanyanswers

interface QuestionAnswerService {
    fun loadQuestionList(): String?

    fun loadAnswersByQuestionId(id: Int): String?
}
