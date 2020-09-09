package com.app.poststestproject.data.remote.response

import com.app.poststestproject.data.model.Post
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostsResponse(

    @SerializedName("")
    @Expose
    var posts: List<Post>
)