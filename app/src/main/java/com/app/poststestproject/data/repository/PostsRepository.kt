package com.app.poststestproject.data.repository

import com.app.poststestproject.data.local.db.DatabaseService
import com.app.poststestproject.data.remote.NetworkService
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchPosts() = networkService.doPostsCall().map { it }

    fun fetchLocalPosts() = databaseService.postsDao().getAll()

}