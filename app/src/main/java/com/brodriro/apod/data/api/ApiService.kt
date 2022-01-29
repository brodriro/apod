package com.brodriro.apod.data.api

import com.brodriro.apod.data.model.PostModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    companion object {
        private const val API_KEY = "gvRodFIhcgDAxCX24eZm6PtQmMarYYgauUil0hoR"
        private const val QUERY_START_DATE = "start_date"
        private const val PATH = "planetary/apod?api_key=$API_KEY"
    }

    @Headers("Content-Type: application/json")
    @GET(PATH)
    fun getPosts(@Query(QUERY_START_DATE) startDate : String): Single<List<PostModel>>

}