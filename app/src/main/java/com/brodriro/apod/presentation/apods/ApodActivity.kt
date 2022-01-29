package com.brodriro.apod.presentation.apods

import android.os.Bundle
import android.util.Log
import android.view.View
import com.brodriro.apod.R
import com.brodriro.apod.databinding.ActivityMainBinding
import com.brodriro.apod.domain.entities.PostEntity
import com.brodriro.apod.presentation.apods.viewholder.PostAdapter
import com.brodriro.apod.presentation.base.BaseDaggerActivity
import com.google.gson.Gson

class ApodActivity : BaseDaggerActivity<ApodContract.Presenter>(), ApodContract.View {
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

    override fun getLayout(): View  {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun showLoading() {
        Log.d(TAG, "showLoading")
    }

    override fun hideLoading() {
        Log.d(TAG, "hideLoading")
    }

    override fun populateList(list: List<PostEntity>) {
        Log.d(TAG, "populateList: ${Gson().toJson(list)}")
        binding.rvPosts.adapter = PostAdapter(list)
    }

    override fun showError(throwable: Throwable) {
        Log.d(TAG, "showError: $throwable")
    }
}