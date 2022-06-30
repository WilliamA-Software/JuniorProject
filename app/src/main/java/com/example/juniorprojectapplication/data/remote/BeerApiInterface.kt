package com.example.juniorprojectapplication.data.remote

import com.example.juniorprojectapplication.core.Constants
import com.example.juniorprojectapplication.data.model.Beer
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApiInterface {

    @GET(Constants.API)
    fun getBeers(@Query("id") type:String) : Call<Beer>

    companion object {

        private var BASE_URL = Constants.API
        fun create() : BeerApiInterface {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BeerApiInterface::class.java)

        }
    }
}