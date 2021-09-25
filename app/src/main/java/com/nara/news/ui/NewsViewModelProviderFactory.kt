package com.nara.news.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nara.news.Repository.NewsRepository

class NewsViewModelProviderFactory(
        val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}