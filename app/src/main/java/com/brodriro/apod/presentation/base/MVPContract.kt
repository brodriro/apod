package com.brodriro.apod.presentation.base


interface MVPContract {

    interface BasePresenter<T : BaseView> {
        fun bindView(view: T)
        fun unbindView()
        val view: T
    }

    interface BaseView {

    }

}