package com.epi.epiphoto.data.repository

import com.epi.epiphoto.BuildConfig
import com.epi.epiphoto.data.model.Photo
import com.epi.epiphoto.data.remote.Api
import com.epi.epiphoto.utils.Resource
import javax.inject.Inject

class Repository @Inject constructor(private val api : Api )  {

    suspend fun getRandomPhotos(): Resource<List<Photo>> = try {
        val clientId = BuildConfig.CLIENT_ID
        val res = api.getRandomPhotos(clientId,16)
        if(res.code() == 200){
            Resource.success(res.body())
        }else {
            Resource.error(res.code().toString())
        }
    }catch (ex:Exception){
        Resource.error(ex.message!!)
    }
}