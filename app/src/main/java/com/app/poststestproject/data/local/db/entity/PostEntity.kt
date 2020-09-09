package com.app.poststestproject.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "posts_entity")
data class PostEntity(

    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Long,

    @ColumnInfo(name = "user_id")
    @NotNull
    val userId: Long,

    @ColumnInfo(name = "post_id")
    @NotNull
    val postId: Long,

    @ColumnInfo(name = "title")
    @NotNull
    val title: String,

    @ColumnInfo(name = "body")
    @NotNull
    val body: String
)