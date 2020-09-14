package com.rmoss.somanyanswers

import java.util.ArrayList
import java.util.HashMap

object Question {

    val ITEMS: MutableList<Question> = ArrayList()

    private val ITEM_MAP: MutableMap<Int, Question> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(
                createDummyItem(
                    i
                )
            )
        }
    }

    private fun addItem(item: Question) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): Question {
        return Question(
            position,
            "Item $position"
        )
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class Question(val id: Int, val title: String) {
        override fun toString(): String = title
    }
}