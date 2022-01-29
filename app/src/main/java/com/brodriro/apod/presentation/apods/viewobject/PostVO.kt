package com.brodriro.apod.presentation.apods.viewobject

import android.os.Parcelable
import com.brodriro.apod.domain.entities.PostEntity
import kotlinx.parcelize.Parcelize

@Parcelize
class PostVO(
    val copyright: String,
    val date: String,
    val explanation: String,
    val url: String,
    val title: String
) : Parcelable

fun PostEntity.toVO(): PostVO = PostVO(
    copyright,
    date,
    explanation,
    url,
    title
)