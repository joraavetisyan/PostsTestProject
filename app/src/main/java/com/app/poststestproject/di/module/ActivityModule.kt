package com.app.poststestproject.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.poststestproject.data.repository.PostsRepository
import com.app.poststestproject.ui.base.BaseActivity
import com.app.poststestproject.ui.posts.PostsViewModel
import com.app.poststestproject.utils.network.NetworkHelper
import com.app.poststestproject.utils.rx.SchedulerProvider
import com.app.poststestproject.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun providePostsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        postsRepository: PostsRepository
    ): PostsViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(PostsViewModel::class) {
            PostsViewModel(schedulerProvider, compositeDisposable, networkHelper, postsRepository)
        }).get(PostsViewModel::class.java)

}