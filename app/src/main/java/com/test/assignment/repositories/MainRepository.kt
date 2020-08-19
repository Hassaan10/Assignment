package com.test.assignment.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.assignment.api.ApiBuilder
import com.test.assignment.api.UrlShortenerAPI
import com.test.assignment.models.Actor
import com.test.assignment.models.Event
import com.test.assignment.models.UrlResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    val api = ApiBuilder.getInstance()?.create(UrlShortenerAPI::class.java)

    var error = MutableLiveData<String>()
    val urlResponse = MutableLiveData<UrlResponse>()

    //add event
    fun addEvent(event: Event)
    {
        api?.addEvent(event)?.enqueue(object :Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
            error.value = t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {

            }
        })
    }


    //get all actors
    fun getActors()
    {
        api?.getActors()?.enqueue(object :Callback<List<Actor>>{
            override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                error.value = t.localizedMessage
            }

            override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) {
                TODO("Not yet implemented")
            }
        })
    }

    //get events by actor id
    fun getActorsEvent(id:String)
    {
        api?.getActorEvents(id)?.enqueue(object :Callback<List<Event>>{
            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                error.value = t.localizedMessage
            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                TODO("Not yet implemented")
            }
        })
    }

    //get shorten url from bitly api
    fun getShortenUrl(url:String)
    {

        api?.getShortenUrl(url)?.enqueue(object :Callback<UrlResponse>{
            override fun onFailure(call: Call<UrlResponse>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<UrlResponse>, response: Response<UrlResponse>) {
                if(response.isSuccessful)
                {
                    urlResponse.value = response.body()
                }
            }

        })
    }


}