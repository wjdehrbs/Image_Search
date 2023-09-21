package com.example.search.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class SearchModel(
    @SerializedName("documents")
    val documents: ArrayList<Documents>,

    @SerializedName("meta")
    val meta: Meta
) {

    data class Documents(
        @SerializedName("collection") val collection: String,
        @SerializedName("thumbnail_url") val thumbnailUrl: String,
        @SerializedName("display_sitename") val displaySiteName: String,
        @SerializedName("datetime") val datetime: String,
        @SerializedName("image_url") val imageUrl: String,
        @SerializedName("width") val width: Int,
        @SerializedName("heigth") val height: Int,
        @SerializedName("doc_url") val docUrl: String
    )

    data class Meta(
        val is_end: Boolean,
        val pageable_count: Int,
        val total_count: Int
    )
}