package com.example.assignmentappspasybin.model

import com.example.assignmentappspasybin.model.data.DataSet
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET("search_by_date?tags=story")
    suspend fun getPages(
        @Query("page") page: Int
    ): DataSet

    companion object {
        private const val BASE_URL = "https://hn.algolia.com/api/v1/"

        fun create(): NetworkApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(NetworkApi::class.java)
        }
    }
}