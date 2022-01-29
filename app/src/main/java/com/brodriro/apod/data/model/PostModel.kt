package com.brodriro.apod.data.model

import com.brodriro.apod.domain.entities.PostEntity

data class PostModel(
    val copyright: String?,
    val date: String?,
    val explanation: String?,
    val hdurl: String?,
    val media_type: String?,
    val service_version: String?,
    val title: String?,
    val url: String?,
)

fun PostModel.toEntity(): PostEntity = PostEntity(
    copyright.orEmpty(),
    date.orEmpty(),
    explanation.orEmpty(),
    url.orEmpty(),
    title.orEmpty()
)