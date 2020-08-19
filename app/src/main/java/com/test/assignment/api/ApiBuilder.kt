package com.test.assignment.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder {

    companion object {
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
//                    .baseUrl("http://localhost:8000")
                    .baseUrl("https://api-ssl.bitly.com/v4/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}