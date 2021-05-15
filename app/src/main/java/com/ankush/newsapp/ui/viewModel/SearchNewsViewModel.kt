package com.ankush.newsapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankush.newsapp.model.ArticleResponse
import com.ankush.newsapp.repository.NewsRepository
import com.ankush.newsapp.repository.SearchNewsRespository

class SearchNewsViewModel:ViewModel() {
    var serviceLiveData = MutableLiveData<ArticleResponse>()
    fun getUser(searchText: String) : LiveData<ArticleResponse>? {
        serviceLiveData = SearchNewsRespository().getServiceApiCall(searchText)
        return serviceLiveData
    }
}