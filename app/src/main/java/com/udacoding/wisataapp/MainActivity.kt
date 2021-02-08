package com.udacoding.wisataapp

import android.os.Bundle
import android.os.RecoverySystem
import android.util.JsonWriter
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), WisataView {

  private  var presenter : WisataPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WisataPresenter(this)
        presenter?.getWisata()


    }

    private fun showData(data: List<Wisata>?) {


        val adapter = data?.let { WisataAdapter(it) }
        val listWisata = findViewById<RecyclerView>(R.id.listWisata)
        listWisata.adapter = adapter
        listWisata.layoutManager = LinearLayoutManager(this)
    }

    override fun onSuccess(msg: String, data: List<Wisata>) {
        showData(data)
    }

    override fun onFailure(msg: String) {
        //show tasot
    }
}