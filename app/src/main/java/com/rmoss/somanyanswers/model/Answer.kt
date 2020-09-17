package com.rmoss.somanyanswers.model

import com.beust.klaxon.Json

data class Answer(
    @Json(name = "answer_id")
    val id: Int,
    var body: String,
    @Json(name = "is_accepted")
    val isAccepted: Boolean
)

data class AnswerParsedJson(val items: MutableList<Answer>)