package com.nara.news.Repository

import com.nara.news.api.RetrofitInstance
import com.nara.news.db.ArticleDatabase
import com.nara.news.model.Article
import retrofit2.Retrofit

class NewsRepository(
        val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode : String,pageNumber: Int) =
            RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery : String, pageNumber: Int) =
            RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article : Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticle()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}