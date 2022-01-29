package com.brodriro.apod.presentation.apods

import com.brodriro.apod.presentation.base.AbstractPresenter
import javax.inject.Inject

class ApodPresenter @Inject constructor() : AbstractPresenter<ApodContract.View>(),
    ApodContract.Presenter {
}