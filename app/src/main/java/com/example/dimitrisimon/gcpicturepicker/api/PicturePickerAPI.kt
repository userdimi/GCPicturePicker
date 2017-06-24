package com.example.dimitrisimon.gcpicturepicker.api

import com.example.dimitrisimon.gcpicturepicker.model.GetPictures
import retrofit2.http.POST
import com.example.dimitrisimon.gcpicturepicker.model.PostPictures
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET


/**
 * (c) Dimitri Simon on 24.06.17
 */

interface PicturePickerAPI {

  //Post pictures
 @POST("/pictures")
    fun addPics(@Body postPicture: PostPictures) : Call<PostPictures>

 @GET("/pictures")
    fun getPics() : Call<GetPictures>
}