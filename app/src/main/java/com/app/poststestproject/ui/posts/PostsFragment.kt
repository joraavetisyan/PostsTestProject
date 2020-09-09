package com.app.poststestproject.ui.posts

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.poststestproject.R
import com.app.poststestproject.di.component.FragmentComponent
import com.app.poststestproject.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_posts_list.*
import javax.inject.Inject

class PostsFragment : BaseFragment<PostsViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var postsAdapter: PostsAdapter

    override fun provideLayoutId() = R.layout.fragment_posts_list

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        rv_posts.layoutManager = linearLayoutManager
        rv_posts.adapter = postsAdapter
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.getPostsLiveData().observe(this, {
            it?.run {
                postsAdapter.submitList(this)
            }
        })
    }

}