package com.nara.news.Repository

import com.nara.news.api.RetrofitInstance
import com.nara.news.db.ArticleDatabase
import retrofit2.Retrofit

class NewsRepository(
        val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode : String,pageNumber: Int) =
            RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)
}