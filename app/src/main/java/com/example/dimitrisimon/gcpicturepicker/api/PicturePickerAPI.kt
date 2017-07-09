package com.example.dimitrisimon.gcpicturepicker.api

import com.example.dimitrisimon.gcpicturepicker.model.GetPictures
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.Part



/**
 * (c) Dimitri Simon on 24.06.17
 */

interface PicturePickerAPI {

    @Multipart
    @POST("upload")
    fun upload(
            @Part picture: MultipartBody.Part
    ): Call<ResponseBody>


    @GET("/pictures")
    fun getPics(): Call<GetPictures>
}

