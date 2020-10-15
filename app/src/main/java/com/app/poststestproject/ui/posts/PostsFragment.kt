package com.app.poststestproject.ui.posts

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.poststestproject.PostsActivity
import com.app.poststestproject.R
import com.app.poststestproject.data.model.Post
import com.app.poststestproject.di.component.FragmentComponent
import com.app.poststestproject.ui.base.BaseFragment
import com.app.poststestproject.ui.posts.details.PostDetailsFragment
import kotlinx.android.synthetic.main.fragment_posts_list.*
import javax.inject.Inject
import javax.inject.Provider

class PostsFragment : BaseFragment<PostsViewModel>(), PostsAdapter.OnItemClickListener {

    private var posts: List<Post>? = null

    companion object {
        const val TAG = "PostsFragment"
    }

    @Inject
    lateinit var linearLayoutManager: Provider<LinearLayoutManager>

    @Inject
    lateinit var postsAdapter: PostsAdapter

    override fun provideLayoutId() = R.layout.fragment_posts_list

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        rv_posts.layoutManager = linearLayoutManager.get()
        rv_posts.adapter = postsAdapter
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.getPostsLiveData().observe(this, {
            it?.run {
                posts = this
                postsAdapter.submitList(this)
            }
        })
        viewModel.getLoadingLiveData().observe(this, {
            pb_loading.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    override fun onItemClick(post: Post) {
        (requireActivity() as PostsActivity).showPostDetailsFragment(post)
    }

    override fun onFavoriteItemClick(position: Int) {
        posts!!.get(position).apply {
            isFavorite = !isFavorite
        }
    }
}