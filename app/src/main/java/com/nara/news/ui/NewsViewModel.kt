package com.nara.news.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nara.news.Repository.NewsRepository
import com.nara.news.model.NewsResponse
import com.nara.news.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
        val newRepository : NewsRepository
): ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("us")
    }
    fun getBreakingNews(countryCode : String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newRepository.getBreakingNews(countryCode,breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))

    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}