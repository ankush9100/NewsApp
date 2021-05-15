package com.ankush.newsapp.api

import com.ankush.newsapp.model.ArticleResponse
import com.ankush.newsapp.utils.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
        fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apiKey: String = API_KEY
    ): Call<ArticleResponse>

    @GET("/v2/everything")
    fun getSearchedNews(
        @Query("q")
        searchString: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apiKey: String = API_KEY
    ): Call<ArticleResponse>
}