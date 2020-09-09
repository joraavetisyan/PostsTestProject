package com.app.poststestproject.di.component

import android.app.Application
import android.content.Context
import com.app.poststestproject.PostsApp
import com.app.poststestproject.data.local.db.DatabaseService
import com.app.poststestproject.di.ApplicationContext
import com.app.poststestproject.data.remote.NetworkService
import com.app.poststestproject.data.repository.PostsRepository
import com.app.poststestproject.di.module.ApplicationModule
import com.app.poststestproject.utils.network.NetworkHelper
import com.app.poststestproject.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: PostsApp)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper

    fun getPostsRepository(): PostsRepository

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable
}