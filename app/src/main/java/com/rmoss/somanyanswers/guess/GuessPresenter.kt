package com.rmoss.somanyanswers.guess

import android.os.AsyncTask
import android.text.Html
import com.beust.klaxon.Klaxon
import com.rmoss.somanyanswers.QuestionAnswerService
import com.rmoss.somanyanswers.StackOverflowQAService
import com.rmoss.somanyanswers.model.Answer
import com.rmoss.somanyanswers.model.AnswerParsedJson

class GuessPresenter(private val guessFragment: GuessFragment){
    private val qaService: QuestionAnswerService = StackOverflowQAService()

    fun loadAnswers(id: Int) {
        HTTPAsyncTask().execute(id)
    }

    private fun formatResult(result: String): List<Answer> {
        val parsedJson = Klaxon().parse<AnswerParsedJson>(result)
        transformBodyFromHtmlToString(parsedJson!!.items)
        return parsedJson.items
    }

    private fun transformBodyFromHtmlToString(items: MutableList<Answer>) {
        items.forEach {
            it.body = Html.fromHtml(it.body, 0).toString()
        }
    }

    inner   class HTTPAsyncTask : AsyncTask<Int?, String?, String?>() {

        override fun doInBackground(vararg params: Int?): String? {
            return qaService.loadAnswersByQuestionId(params[0]!!)
        }
        override fun onPostExecute(result: String?) {
            guessFragment.setAnswerList(formatResult(result!!))
        }

    }
}