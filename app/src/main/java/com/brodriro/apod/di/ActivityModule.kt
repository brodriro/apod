package com.brodriro.apod.di

import com.brodriro.apod.presentation.apods.ApodContract
import com.brodriro.apod.presentation.apods.ApodPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityModule {

   @Binds
    abstract fun provideApodPresenter(presenter: ApodPresenter) : ApodContract.Presenter
}