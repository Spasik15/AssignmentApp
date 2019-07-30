package com.example.assignmentappspasybin.model.data

import androidx.recyclerview.widget.DiffUtil

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.created_at == newItem.created_at &&
                oldItem.author == newItem.author &&
                oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}