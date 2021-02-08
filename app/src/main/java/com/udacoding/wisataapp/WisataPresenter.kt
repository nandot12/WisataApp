package com.udacoding.wisataapp

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WisataPresenter(val wisataView : WisataView) {


    fun getWisata(){

        ConfigNetwork.initService().getWisata()
                .enqueue(object  : Callback<ResponseSeer> {
                    override fun onFailure(call: Call<ResponseSeer>, t: Throwable) {
                        //handle error

                        wisataView.onFailure(t.message ?: "")
                    }

                    override fun onResponse(call: Call<ResponseSeer>, response: Response<ResponseSeer>) {

                        if(response.isSuccessful){
                            val data = response.body()?.data
                            if(data?.size ?: 0 > 0){
                                //show data
                                response.body()?.data?.let { wisataView.onSuccess(response.message(), it) }

                            }
                            else{
                                wisataView.onFailure(response.message())

                            }
                        }
                    }
                })
    }
}