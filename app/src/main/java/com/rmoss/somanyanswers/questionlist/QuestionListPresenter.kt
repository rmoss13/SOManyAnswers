package com.rmoss.somanyanswers.questionlist

import android.os.AsyncTask
import android.text.Html
import com.beust.klaxon.Klaxon
import com.rmoss.somanyanswers.QuestionAnswerService
import com.rmoss.somanyanswers.StackOverflowQAService
import com.rmoss.somanyanswers.model.Question
import com.rmoss.somanyanswers.model.QuestionParsedJson

class QuestionListPresenter(private val questionListFragment: QuestionListFragment){
    private val qaService: QuestionAnswerService = StackOverflowQAService()

    fun loadQuestions() {
        HTTPAsyncTask().execute()
    }

    private fun formatResult(result: String): List<Question> {
        val parsedJson = Klaxon().parse<QuestionParsedJson>(result)
        val filter =
            parsedJson!!.items.filter { question -> question.isAnswered && question.answerCount > 1 }
        filter.forEach { question ->
            question.body = Html.fromHtml(question.body, 0).toString()
        }
        return filter
    }

    inner   class HTTPAsyncTask : AsyncTask<String?, String?, String?>() {

        override fun doInBackground(vararg params: String?): String? {
            return qaService.loadQuestionList()
        }
        override fun onPostExecute(result: String?) {
            questionListFragment.questionList = formatResult(result!!)
        }

    }
}