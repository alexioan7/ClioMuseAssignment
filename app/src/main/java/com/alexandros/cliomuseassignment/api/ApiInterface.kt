package com.alexandros.cliomuseassignment.api

import com.alexandros.cliomuseassignment.api.responseModel.TourData
import retrofit2.http.GET
import retrofit2.Call

interface ApiInterface {


    @GET("tour.json")
    fun requestTours(): Call<TourData>
}