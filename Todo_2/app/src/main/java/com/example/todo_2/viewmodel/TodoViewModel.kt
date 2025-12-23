package com.example.todo_2.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_2.model.Todo
import com.example.todo_2.model.TodosApi
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    val todos = mutableStateListOf<Todo>()

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL",e.message.toString())
            }
        }
    }
}
