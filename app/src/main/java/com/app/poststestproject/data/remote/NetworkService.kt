package com.app.poststestproject.data.remote

import com.app.poststestproject.data.model.Post
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.POSTS)
    fun doPostsCall(): Single<List<Post>>

}