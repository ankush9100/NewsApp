package com.ankush.newsapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ankush.newsapp.api.RetrofitInstance
import com.ankush.newsapp.model.ArticleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchNewsRespository {


    val serviceSetterGetter = MutableLiveData<ArticleResponse>()


    fun getServiceApiCall(searchText: String): MutableLiveData<ArticleResponse> {
        val call = RetrofitInstance().api.getSearchedNews(searchText,1)
        call.enqueue(object : Callback<ArticleResponse> {
            override fun onResponse(
                call: Call<ArticleResponse>,
                response: Response<ArticleResponse>
            ) {
                Log.v("DEBUGfff : ", response.body().toString())

                val data = response.body()
                serviceSetterGetter.value = data
            }

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                Log.v("DEBUGsssss : ", "llll")
            }

        })
        return serviceSetterGetter


    }
}