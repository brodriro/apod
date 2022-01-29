package com.brodriro.apod.presentation.apods

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.brodriro.apod.databinding.ActivityMainBinding
import com.brodriro.apod.domain.entities.PostEntity
import com.brodriro.apod.presentation.apods.viewholder.PostAdapter
import com.brodriro.apod.presentation.apods.viewobject.toVO
import com.brodriro.apod.presentation.base.BaseDaggerActivity
import com.brodriro.apod.presentation.detail.DetailActivity
import android.app.ActivityOptions

import android.widget.ImageView
import com.brodriro.apod.R


class ApodActivity : BaseDaggerActivity<ApodContract.Presenter>(), ApodContract.View,
    PostAdapter.AdapterListener {
    companion object {
        const val TAG = "ApodActivity"
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.init()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun getLayout(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun showLoading() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.pbLoading.visibility = View.GONE
    }

    override fun populateList(list: List<PostEntity>) {
        binding.rvPosts.adapter = PostAdapter(list, this)
    }

    override fun showError(throwable: Throwable) {
        Log.d(TAG, "showError: $throwable")
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(postEntity: PostEntity, ivPicture: View) {
        val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
            this, ivPicture, getString(R.string.explodeItem)
        )
        startActivity(DetailActivity.getIntent(postEntity.toVO(), this), options.toBundle())
    }
}