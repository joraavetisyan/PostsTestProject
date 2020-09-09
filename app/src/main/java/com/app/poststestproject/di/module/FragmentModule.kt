package com.app.poststestproject.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.poststestproject.data.repository.PostsRepository
import com.app.poststestproject.ui.base.BaseFragment
import com.app.poststestproject.ui.posts.PostsAdapter
import com.app.poststestproject.ui.posts.PostsViewModel
import com.app.poststestproject.utils.network.NetworkHelper
import com.app.poststestproject.utils.rx.SchedulerProvider
import com.app.poststestproject.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun providePostsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        postsRepository: PostsRepository,
    ): PostsViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(PostsViewModel::class) {
                PostsViewModel(schedulerProvider, compositeDisposable, networkHelper, postsRepository)
            }
        ).get(PostsViewModel::class.java)

    @Provides
    fun providePostsAdapter() = PostsAdapter(ArrayList())

}