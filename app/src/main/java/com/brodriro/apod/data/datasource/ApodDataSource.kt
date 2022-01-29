package com.brodriro.apod.data.datasource

import com.brodriro.apod.data.model.PostModel
import io.reactivex.Single

interface ApodDataSource {
    fun getPosts(date: String): Single<List<PostModel>>
}