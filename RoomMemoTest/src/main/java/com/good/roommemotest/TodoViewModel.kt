
package com.example.android.roomwordssample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TodoRepository
    val allWords: LiveData<List<Todo>>

    init {
        val todoDao = TodoRoomDatabase.getDatabase(application, viewModelScope).todoDao()
        repository = TodoRepository(todoDao)
        allWords = repository.allWords
    }
    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }
}
