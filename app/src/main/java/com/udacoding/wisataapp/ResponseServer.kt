package com.udacoding.wisataapp


data class
ResponseSeer(val status_code : String,var message : String,val data :List<Wisata>)

data class Wisata(var id : String,var  nama_tempat : String)
