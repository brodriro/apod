package com.brodriro.apod.data.datasource.remote

import com.brodriro.apod.data.api.ApiService
import com.brodriro.apod.data.datasource.ApodDataSource
import com.brodriro.apod.data.model.PostModel
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class ApodDataSourceRemote @Inject constructor(private val api: ApiService) : ApodDataSource {
    override fun getPosts(date: String): Single<List<PostModel>> {
        return api.getPosts(date)
    }
}