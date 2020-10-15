package com.app.poststestproject.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(

    @SerializedName("userId")
    @Expose
    var userId: Long,

    @SerializedName("id")
    @Expose
    var postId: Long,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String,

    var isFavorite: Boolean

): Parcelable