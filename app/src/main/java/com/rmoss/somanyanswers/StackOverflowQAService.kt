package com.rmoss.somanyanswers

import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.GZIPInputStream

class StackOverflowQAService : QuestionAnswerService {
    override fun loadQuestionList(): String? {
        val url =
            URL("https://api.stackexchange.com/2.2/questions?page=1&pagesize=20&order=desc&sort=month&site=stackoverflow&filter=!4(L6loqBHp1ct1eg1")

        val connection = url.openConnection() as HttpURLConnection
        return connection.inputStream.bufferedReader().use { it.readText() }
    }

    override fun loadAnswersByQuestionId(id: Int): String? {
        //https://api.stackexchange.com/2.2/questions/63609077/answers?order=desc&sort=activity&site=stackoverflow&filter=!bM7*SVS7tQktB1
        return ""
    }
}
