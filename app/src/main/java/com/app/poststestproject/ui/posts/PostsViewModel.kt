package com.app.poststestproject.ui.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.app.poststestproject.data.model.Post
import com.app.poststestproject.data.repository.PostsRepository
import com.app.poststestproject.ui.base.BaseViewModel
import com.app.poststestproject.utils.common.Resource
import com.app.poststestproject.utils.network.NetworkHelper
import com.app.poststestproject.utils.rx.SchedulerProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class PostsViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val postsRepository: PostsRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val mPostsLiveData: MutableLiveData<Resource<List<Post>>> = MutableLiveData()
    private val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun getPostsLiveData() = Transformations.map(mPostsLiveData) { it.data }

    fun getLoadingLiveData() = isLoadingLiveData

    override fun onCreate() {
        if (checkInternetConnection()) {
            isLoadingLiveData.postValue(true)
            compositeDisposable.add(postsRepository.fetchPosts()
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    {
                        isLoadingLiveData.postValue(false)
                        mPostsLiveData.postValue(Resource.success(it))
                    },
                    {
                        isLoadingLiveData.postValue(false)
                        handleNetworkError(it)
                        mPostsLiveData.postValue(Resource.error())
                    }
                )
            )
        } else {
            compositeDisposable.add(Single.just(postsRepository.fetchPosts())
                .subscribeOn(schedulerProvider.io())
                .map { it.blockingGet() }
                .subscribe { t ->
                    run {
                        mPostsLiveData.postValue(Resource.success(t))
                    }
                })
        }
    }


}