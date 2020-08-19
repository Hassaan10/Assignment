package com.test.assignment.api

import com.test.assignment.models.Actor
import com.test.assignment.models.Event
import retrofit2.Call
import retrofit2.http.*


interface UrlShortenerAPI {

    @POST("events/")
    fun addEvent(@Body event: Event): Call<String>

    @GET("events/")
    fun getEvents():Call<List<Event>>

    @GET("actors/")
    fun getActors():Call<List<Actor>>

    @PUT("actors")
    fun updateActor(@Body actor: Actor) :Call<String>

    @DELETE("erase")
    fun deleteAll()

    @GET("events/actors/{id}")
    fun getActorEvents(@Path("id") id:String):Call<List<Event>>
}