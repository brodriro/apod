package com.brodriro.apod.di

import com.brodriro.apod.data.api.ApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        val builder = Retrofit.Builder()
        builder.baseUrl("https://api.nasa.gov/")
        builder.addConverterFactory(GsonConverterFactory.create(Gson()))
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        return builder.build()
    }

    @Reusable
    @Provides
    fun provideAPi(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

}