package com.udacoding.wisataapp

interface WisataView {

    fun onSuccess(msg : String,data : List<Wisata>)
    fun onFailure(msg : String)
}