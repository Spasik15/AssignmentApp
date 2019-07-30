package com.example.assignmentappspasybin.model.data

data class Post(
    val created_at: String,
    val title: String,
    val author: String
) {
    val createdAt: String
        get() = "Created at $created_at"
}