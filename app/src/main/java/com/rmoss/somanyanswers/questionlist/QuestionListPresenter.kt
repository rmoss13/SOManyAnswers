package com.rmoss.somanyanswers.questionlist

import android.os.AsyncTask
import com.rmoss.somanyanswers.QuestionService
import com.rmoss.somanyanswers.StackOverflowQuestionService
import com.rmoss.somanyanswers.model.Question

class QuestionListPresenter(private val questionListFragment: QuestionListFragment){
    private val questionService: QuestionService = StackOverflowQuestionService()

    fun loadQuestions() {
        HTTPAsyncTask().execute()
    }

    private fun formatResult(result: String?): List<Question> {
        return listOf(
            Question(1, "What can I do? 1"),
            Question(2, "What can I do? 2"),
            Question(3, "What can I do? 3"),
            Question(4, "What can I do? 4")
        )
    }

    inner   class HTTPAsyncTask : AsyncTask<String?, String?, String?>() {

        override fun doInBackground(vararg params: String?): String? {
//            return questionService.loadQuestionList()
            return ""
        }
        override fun onPostExecute(result: String?) {
            questionListFragment.questionList = formatResult(result)
        }

    }
}