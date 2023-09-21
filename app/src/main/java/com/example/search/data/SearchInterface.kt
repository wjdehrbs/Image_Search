package com.example.search.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface SearchInterface {
    @GET("v2/search/image")
     fun search_image(
        @Header("Authorization") apiKey: String = Constants.AUTH_HEADER,
        @Query("query") query: String?,
        @Query("sort") sort: String?,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<SearchModel>
}


class Constants {
    companion object{
        const val AUTH_HEADER = "KakaoAK 0035c0f3b5a53a1b1b228c4d8b070133"
    }
}