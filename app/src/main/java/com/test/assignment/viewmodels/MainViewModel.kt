package com.test.assignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.assignment.models.UrlResponse
import com.test.assignment.repositories.MainRepository

class MainViewModel:ViewModel() {

    val repository = MainRepository()

    val response = repository.urlResponse

    val error = repository.error

    fun getShortenUrl(url:String)
    {
       repository.getShortenUrl(url)
    }

}