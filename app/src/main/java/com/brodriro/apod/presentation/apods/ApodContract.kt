package com.brodriro.apod.presentation.apods;

import com.brodriro.apod.domain.entities.PostEntity
import com.brodriro.apod.presentation.base.MVPContract

interface ApodContract {

    interface Presenter : MVPContract.BasePresenter<View> {
        fun init()
        fun onStop()

    }

    interface View : MVPContract.BaseView {
        fun showLoading()
        fun hideLoading()
        fun populateList(list: List<PostEntity>)
        fun showError(throwable: Throwable)
    }
}
