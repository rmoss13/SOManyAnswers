package com.rmoss.somanyanswers

import com.rmoss.somanyanswers.model.Question
import java.net.HttpURLConnection
import java.net.URL

class StackOverflowQuestionService : QuestionService {
    override fun loadQuestionList(): String? {
//        val url =
//            URL("https://api.stackexchange.com/2.2/questions?page=1&pagesize=10&order=desc&sort=hot&site=stackoverflow")
//        val connection = url.openConnection() as HttpURLConnection
//        return connection.inputStream.bufferedReader().use { it.readText() }
        return ""
    }
}
