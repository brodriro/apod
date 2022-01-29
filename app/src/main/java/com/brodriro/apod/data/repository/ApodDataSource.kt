package com.brodriro.apod.data.repository

import com.brodriro.apod.data.datasource.ApodDataSource
import com.brodriro.apod.data.model.toEntity
import com.brodriro.apod.domain.entities.PostEntity
import com.brodriro.apod.domain.repository.ApodRepositoty
import io.reactivex.Single
import javax.inject.Inject

class ApodRepositoryData @Inject constructor(private val datasource: ApodDataSource) :
    ApodRepositoty {
    override fun getPosts(date: String): Single<List<PostEntity>> {
        return datasource.getPosts(date).map { list ->
            list.map { it.toEntity() }
        }
    }
}