package com.example.myapplicationwebservice.webservice

import com.example.myapplicationwebservice.model.Article
import retrofit2.http.*

interface DaoArticle {
    @GET("articles")
    suspend fun getArticle(): List<Article>

    @POST("articles")
    suspend fun createArticle(@Body article: Article): Article

    @PUT("articles/{id}")
    suspend fun updateArticle(@Path("id") articleid: Int, @Body article: Article):Article

    @DELETE("articles/{id}")
    suspend fun deleteArticle(@Path("id") articleid: Int)
}
