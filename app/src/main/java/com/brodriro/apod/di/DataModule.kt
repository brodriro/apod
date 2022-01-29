package com.brodriro.apod.di

import com.brodriro.apod.data.datasource.ApodDataSource
import com.brodriro.apod.data.datasource.remote.ApodDataSourceRemote
import com.brodriro.apod.data.repository.ApodRepositoryData
import com.brodriro.apod.domain.repository.ApodRepositoty
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class DataModule {

    @Reusable
    @Provides
    fun provideRepository(repositoryData: ApodRepositoryData) : ApodRepositoty {
        return repositoryData
    }

    @Reusable
    @Provides
    fun provideDataSource(dataSource: ApodDataSourceRemote) : ApodDataSource {
        return dataSource
    }
}