package com.example.apitest.repo

import com.example.apitest.model.Breed
import com.example.apitest.repo.remote.RetrofitInstance
import retrofit2.Response

object CatRepo {
    suspend fun getImages(attach_breed: Int): Response<List<Breed>>{
        return RetrofitInstance.catService.getImages(attach_breed, 1 ,3)
    }
}