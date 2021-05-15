package com.ankush.newsapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankush.newsapp.model.ArticleResponse
import com.ankush.newsapp.repository.NewsRepository

class NewsViewModel:ViewModel() {

    var serviceLiveData = MutableLiveData<ArticleResponse>()
    fun getUser() : LiveData<ArticleResponse>? {
        serviceLiveData = NewsRepository().getServiceApiCall()
        return serviceLiveData
    }
}