package com.app.poststestproject.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.poststestproject.data.local.db.entity.PostEntity

@Dao
interface PostsDao {

    @Query("SELECT * FROM posts_entity")
    fun getAll(): List<PostEntity>

    @Insert
    fun insert(entity: PostEntity)

    @Delete
    fun delete(entity: PostEntity)
}