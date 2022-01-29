package com.brodriro.apod.domain.entities

data class PostEntity(
    val copyright: String,
    val date: String,
    val explanation: String,
    val url: String,
    val title: String
)