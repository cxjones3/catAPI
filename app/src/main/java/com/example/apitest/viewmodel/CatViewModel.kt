package com.example.apitest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apitest.model.Breed
import com.example.apitest.repo.CatRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatViewModel:ViewModel() {

    private val _cats = MutableLiveData<List<Breed>>()
    val cats: LiveData<List<Breed>> get() = _cats

    fun getImages(attach_breed: Int) {
        Log.d("vm","here")
        viewModelScope.launch(Dispatchers.IO) {
            val response = CatRepo.getImages(attach_breed)
            val list = if (response.isSuccessful && !response.body().isNullOrEmpty())
                response.body()
            else listOf("ERROR")
            list?.let { urls -> _cats.postValue(urls as List<Breed>) }
            Log.d("vm","here2")
        }
    }

}