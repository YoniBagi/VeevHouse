package com.veevassignment.network

import com.veevassignment.dataModel.VeevHouse
import retrofit2.http.GET

interface ServiceApi {

    @GET("app")
    suspend fun fetchVeevHouse(): VeevHouse
}