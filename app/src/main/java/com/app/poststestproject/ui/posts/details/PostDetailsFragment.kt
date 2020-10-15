package com.app.poststestproject.ui.posts.details

import android.os.Bundle
import android.view.View
import com.app.poststestproject.R
import com.app.poststestproject.data.model.Post
import com.app.poststestproject.di.component.FragmentComponent
import com.app.poststestproject.ui.base.BaseFragment
import com.app.poststestproject.ui.posts.PostsViewModel
import kotlinx.android.synthetic.main.fragment_post_detail.*
import java.sql.ClientInfoStatus

class PostDetailsFragment : BaseFragment<PostsViewModel>() {

    private lateinit var post: Post

    companion object {
        const val TAG = "PostDetailsFragment"
        const val ARG_SELECTED_POST = "selected_post"

        fun newInstance(post: Post) =
            PostDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_SELECTED_POST, post)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        post = arguments?.getParcelable(ARG_SELECTED_POST)!!
    }

    override fun provideLayoutId() = R.layout.fragment_post_detail

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        post_details_txt.text = post.body
    }

}