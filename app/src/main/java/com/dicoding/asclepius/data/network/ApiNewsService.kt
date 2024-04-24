package com.dicoding.asclepius.data.network

import com.dicoding.asclepius.data.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNewsService {
    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("category") category: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String
    ): News
}
