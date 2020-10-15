package com.app.poststestproject.di.component

import com.app.poststestproject.PostsActivity
import com.app.poststestproject.di.ActivityScope
import com.app.poststestproject.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    //fun inject(activity: PostsActivity)
}