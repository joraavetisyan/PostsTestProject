package com.app.poststestproject.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.poststestproject.data.local.db.dao.PostsDao
import com.app.poststestproject.data.local.db.entity.PostEntity
import javax.inject.Singleton

@Singleton
@Database(
    entities = [
        PostEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun postsDao(): PostsDao
}