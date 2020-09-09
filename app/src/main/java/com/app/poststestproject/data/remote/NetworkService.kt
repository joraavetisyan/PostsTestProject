package com.app.poststestproject.data.remote

import com.app.poststestproject.data.remote.response.PostsResponse
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.POSTS)
    fun doPostsCall(): Single<PostsResponse>

}