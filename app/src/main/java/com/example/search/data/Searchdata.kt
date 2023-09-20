package com.example.search.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class SearchData(
    @SerializedName("collection") val collection: String,
    @SerializedName("thumbnail_url") val thumbnail_url: String,
    @SerializedName("display_sitename") val display_sitename: String,
    @SerializedName("datetime") val datetime: Date
)