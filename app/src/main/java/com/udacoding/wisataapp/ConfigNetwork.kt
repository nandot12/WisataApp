package com.udacoding.wisataapp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ConfigNetwork{



    companion object{

        fun initRetrofit():Retrofit {

            return  Retrofit.Builder()
                    .baseUrl("http://udacoding.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        fun initService():WisataService{

          return  initRetrofit().create(WisataService::class.java)
        }





    }
}

interface WisataService{


    @GET("action=findAll")
    fun getWisata():Call<ResponseSeer>
}