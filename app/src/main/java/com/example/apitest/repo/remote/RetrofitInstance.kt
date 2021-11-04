package com.example.apitest.repo.remote

import com.example.apitest.R
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Headers


object RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val catService: CatService = retrofit.create(CatService::class.java)
}