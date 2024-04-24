package com.dicoding.asclepius.data.network

import com.dicoding.asclepius.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiConfig {
    companion object {
        private const val TOKEN = BuildConfig.API_KEY
        private const val BASE_URL = BuildConfig.API_URL
        fun getApiService(): ApiNewsService {
            val client = OkHttpClient.Builder()
                .build()
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()

            return retrofit.create(ApiNewsService::class.java)
        }
    }
}
