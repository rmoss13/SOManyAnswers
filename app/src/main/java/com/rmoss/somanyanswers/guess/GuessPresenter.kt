package com.rmoss.somanyanswers.guess

import android.os.AsyncTask
import com.rmoss.somanyanswers.QuestionAnswerService
import com.rmoss.somanyanswers.StackOverflowQAService
import com.rmoss.somanyanswers.model.Answer

class GuessPresenter(private val answerRecyclerViewAdapter: AnswerRecyclerViewAdapter){
    private val qaService: QuestionAnswerService = StackOverflowQAService()

    fun loadAnswers(id: Int) {
        HTTPAsyncTask().execute(id)
    }

    private fun formatResult(result: String?): List<Answer> {
        return listOf(
            Answer(1, "This is an answer that one could receive", false),
            Answer(3, "This is an answer that one could receive", false),
            Answer(4, "This is an answer that one could receive", false),
            Answer(2, "This is an answer that one could receive. A CORRECT one", true)
        )
    }

    inner   class HTTPAsyncTask : AsyncTask<Int?, String?, String?>() {

        override fun doInBackground(vararg params: Int?): String? {
//            return qaService.loadAnswersByQuestionId(params[0]!!)
            return ""
        }
        override fun onPostExecute(result: String?) {
            answerRecyclerViewAdapter.setAnswerList(formatResult(result))
        }

    }
}