package com.app.poststestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.poststestproject.data.model.Post
import com.app.poststestproject.ui.base.BaseActivity
import com.app.poststestproject.ui.posts.PostsFragment
import com.app.poststestproject.ui.posts.details.PostDetailsFragment
import kotlinx.android.synthetic.main.activity_main.*

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showPostsFragment(savedInstanceState)
    }

    private fun showPostsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, PostsFragment(), PostsFragment.TAG)
                .commit()
        } else {
            // Данная реализация сделано для правильной обработки бекстека фрагментов при изменении ориентации экрана
            // Если в бекстеке больше одного элемента то отображается последный
            var entryName = PostsFragment.TAG
            if (supportFragmentManager.backStackEntryCount != 0) {
                entryName = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name!!
            }
            val fragment = supportFragmentManager.findFragmentByTag(entryName)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment!!, entryName)
                .commit()
        }
    }

    fun showPostDetailsFragment(post: Post) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, PostDetailsFragment.newInstance(post), PostDetailsFragment.TAG)
            .addToBackStack(PostDetailsFragment.TAG)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStackImmediate()
        else super.onBackPressed()
    }


}