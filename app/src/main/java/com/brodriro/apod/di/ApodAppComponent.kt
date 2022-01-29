package com.brodriro.apod.di


import com.brodriro.apod.presentation.ApodApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        PresentationModule::class
    ]
)
interface ApodAppComponent : AndroidInjector<ApodApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ApodApplication>()
}