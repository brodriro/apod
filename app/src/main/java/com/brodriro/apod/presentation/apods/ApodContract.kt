package com.brodriro.apod.presentation.apods;

import com.brodriro.apod.presentation.base.MVPContract

interface ApodContract {

    interface Presenter : MVPContract.BasePresenter<View> {

    }

    interface View : MVPContract.BaseView {

    }
}
