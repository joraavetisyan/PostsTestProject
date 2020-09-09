package com.app.poststestproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("id")
    @Expose
    var postId: Long,

    @SerializedName("userId")
    @Expose
    var userId: Long,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String
)