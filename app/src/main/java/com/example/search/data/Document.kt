package com.example.search.data

import android.media.Image
import retrofit2.http.GET
import retrofit2.http.QueryMap

data class Document(
    val collection: String,
    val datetime: String,
    val display_sitename: String,
    val thumbnail_url: String
)

interface SearchInterface {
    @GET("https://dapi.kakao.com/v2/search/image")
    suspend fun getImage(@QueryMap param: HashMap<String, String>) : Image
}