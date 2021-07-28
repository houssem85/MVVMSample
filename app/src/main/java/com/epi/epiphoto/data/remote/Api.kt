package com.epi.epiphoto.data.remote

import com.epi.epiphoto.data.model.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("photos/random")
    suspend fun getRandomPhotos(@Query("client_id") clientId : String,@Query("count") count : Int ):Response<List<Photo>>
}