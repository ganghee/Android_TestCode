package com.good.roommemotest

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Todo>> = todoDao.getAlphabetizedWords()

    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}
