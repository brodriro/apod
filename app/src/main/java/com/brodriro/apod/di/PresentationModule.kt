package com.brodriro.apod.di

import com.brodriro.apod.presentation.apods.ApodActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PresentationModule {

    @ApodScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributesAPodActivity(): ApodActivity
}