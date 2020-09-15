package com.rmoss.somanyanswers.questionlist

import com.rmoss.somanyanswers.model.Question

class FakeQuestionRepository : QuestionRepository {
    override fun getQuestionList(callback: QuestionListContract.OnResponseCallback) {
        callback.onResponse(
            mutableListOf(
                Question(1, "Fake Title Here")
            )
        )
    }
}