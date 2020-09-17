package com.rmoss.somanyanswers.model

import com.beust.klaxon.Json

data class Question(
    @Json(name = "question_id") val id: Int,
    val title: String,
    var body: String,
    @Json(name = "is_answered") val isAnswered: Boolean,
    @Json(name = "answer_count") val answerCount: Int,
    val tags: List<String>,
    val score: Int
)

data class QuestionParsedJson(val items: MutableList<Question>)