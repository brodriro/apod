package com.brodriro.apod.presentation

import com.brodriro.apod.di.DaggerApodAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class ApodApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApodAppComponent.builder().create(this)
    }

}