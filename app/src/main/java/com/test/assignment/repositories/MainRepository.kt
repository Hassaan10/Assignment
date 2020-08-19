package com.test.assignment.repositories

import com.test.assignment.api.ApiBuilder
import com.test.assignment.api.UrlShortenerAPI
import com.test.assignment.models.Actor
import com.test.assignment.models.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    val api = ApiBuilder.getInstance()?.create(UrlShortenerAPI::class.java)

    fun addEvent(event: Event)
    {
        api?.addEvent(event)?.enqueue(object :Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {

            }
        })
    }


    fun getActors()
    {
        api?.getActors()?.enqueue(object :Callback<List<Actor>>{
            override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getActorsEvent(id:String)
    {
        api?.getActorEvents(id)?.enqueue(object :Callback<List<Event>>{
            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                TODO("Not yet implemented")
            }
        })
    }


}