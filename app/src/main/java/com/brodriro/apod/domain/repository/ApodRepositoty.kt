package com.brodriro.apod.domain.repository

import com.brodriro.apod.domain.entities.PostEntity
import io.reactivex.Single

interface ApodRepositoty {
    fun getPosts(date: String): Single<List<PostEntity>>
}