package com.app.poststestproject.ui.posts.details

import android.view.View
import com.app.poststestproject.R
import com.app.poststestproject.di.component.FragmentComponent
import com.app.poststestproject.ui.base.BaseFragment
import com.app.poststestproject.ui.posts.PostsViewModel

class PostDetailsFragment : BaseFragment<PostsViewModel>() {
    override fun provideLayoutId() = R.layout.fragment_post_detail

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        TODO("Not yet implemented")
    }

    override fun setupView(view: View) {
        TODO("Not yet implemented")
    }

}