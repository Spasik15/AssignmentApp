package com.example.assignmentappspasybin.model

import com.example.assignmentappspasybin.model.data.Post

class MainRepository(
    private val networkApi: NetworkApi
) {
    suspend fun getPages(pages: Int = 1): List<Post> {
        return networkApi.getPages(pages).hits
    }

    companion object {
        private var instance: MainRepository? = null

        fun getInstance(
            networkApi: NetworkApi
        ) = instance ?: synchronized(this) {
            instance ?: MainRepository(networkApi).also {
                instance = it
            }
        }
    }
}