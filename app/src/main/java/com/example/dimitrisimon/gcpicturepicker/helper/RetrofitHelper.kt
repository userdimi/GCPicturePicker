package com.example.dimitrisimon.gcpicturepicker.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * (c) Dimitri Simon on 09.07.17
 */

class RetrofitHelper {

    val APIENDPOINTURL = ""

    public fun buildRetrofit () {

        //create Retrofit instance
        var builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(APIENDPOINTURL)
                .addConverterFactory(GsonConverterFactory.create())

        var retrofit: Retrofit = builder.build()
    }
}