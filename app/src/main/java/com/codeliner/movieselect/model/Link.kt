package com.codeliner.movieselect.model

import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("suggested_link_text")
    val suggested_link_text: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)