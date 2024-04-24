package com.dicoding.asclepius.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.BuildConfig
import com.dicoding.asclepius.data.model.ArticlesItem
import com.dicoding.asclepius.data.network.ApiConfig
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    companion object {
        const val TAG = "NewsVM"
    }

    private var _articles = MutableLiveData<List<ArticlesItem?>?>()
    val articles: LiveData<List<ArticlesItem?>?> get() = _articles

    fun getAllNews() {
        try {
            viewModelScope.launch {
                val result = ApiConfig.getApiService().getNews(
                    "cancer",
                    "health",
                    "en",
                    BuildConfig.API_KEY
                )
                _articles.value = result.articles
                Log.d(TAG, "getAllNews: $articles")
            }
        } catch (e: Exception) {
            Log.e(TAG, "getAllNews: ${e.printStackTrace()}")
        }
    }

    init {
        getAllNews()
    }
}