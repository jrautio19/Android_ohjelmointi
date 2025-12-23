package com.example.todo_2.model

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)
