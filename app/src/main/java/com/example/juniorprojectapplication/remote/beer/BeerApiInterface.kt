package com.example.juniorprojectapplication.remote.beer

import com.example.juniorprojectapplication.core.Constants
import com.example.juniorprojectapplication.data.model.Beer
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


interface BeerApiInterface {

    @GET(Constants.API)
    fun getBeers(): Call<Beer>

    companion object {

        var BASE_URL = Constants.API
        fun create(): BeerApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(BeerApiInterface::class.java)

        }
    }
}