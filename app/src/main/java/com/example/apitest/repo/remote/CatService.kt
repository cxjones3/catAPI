package com.example.apitest.repo.remote

import com.example.apitest.model.Breed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("v1/breeds")
    suspend fun getImages(
        @Query("attach_breed") attach_breed: Int,
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): Response<List<Breed>>
}