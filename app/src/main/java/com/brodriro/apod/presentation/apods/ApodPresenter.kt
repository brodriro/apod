package com.brodriro.apod.presentation.apods

import com.brodriro.apod.domain.usecases.PostUseCase
import com.brodriro.apod.presentation.base.AbstractPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApodPresenter @Inject constructor(
    private val postUseCase: PostUseCase
) : AbstractPresenter<ApodContract.View>(),
    ApodContract.Presenter {

    private val disposables = CompositeDisposable()

    override fun init() {

        val posts = postUseCase.getPosts("2022-01-20")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .doFinally { view.hideLoading() }
            .subscribe({ list ->
                view.populateList(list)
            }, {
                view.showError(it)
            })

        disposables.add(posts)
    }

    override fun onStop() {
        disposables.clear()
    }
}