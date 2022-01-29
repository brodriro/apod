package com.brodriro.apod.domain.usecases

import com.brodriro.apod.domain.entities.PostEntity
import com.brodriro.apod.domain.repository.ApodRepositoty
import io.reactivex.Single
import javax.inject.Inject

class PostUseCase @Inject constructor(private val repository: ApodRepositoty) {

    fun getPosts(date:String): Single<List<PostEntity>> {
        return repository.getPosts(date)
    }
}