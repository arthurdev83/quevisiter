package com.quevisiter.quevisiter.common.network

import com.quevisiter.quevisiter.common.models.Place
import com.quevisiter.quevisiter.common.models.SearchedPlace
import retrofit2.Call
import retrofit2.http.*

interface PlaceRepository{
    @GET("/places")
    fun getPlaces(): Call<List<SearchedPlace>>

    companion object {

    }
}