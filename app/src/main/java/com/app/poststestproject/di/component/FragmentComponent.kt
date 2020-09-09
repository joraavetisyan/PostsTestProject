package com.app.poststestproject.di.component

import com.app.poststestproject.di.FragmentScope
import com.app.poststestproject.di.module.FragmentModule
import com.app.poststestproject.ui.posts.PostsFragment
import com.app.poststestproject.ui.posts.details.PostDetailsFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: PostsFragment)

    fun inject(fragment: PostDetailsFragment)

}