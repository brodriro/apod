package com.brodriro.apod.presentation.apods

import android.util.Log
import com.brodriro.apod.commons.Utils
import com.brodriro.apod.domain.usecases.PostUseCase
import com.brodriro.apod.presentation.base.AbstractPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApodPresenter @Inject constructor(
    private val postUseCase: PostUseCase,
    private val utils: Utils
) : AbstractPresenter<ApodContract.View>(),
    ApodContract.Presenter {

    private val disposables = CompositeDisposable()

    override fun init() {

        val posts = postUseCase.getPosts(utils.getDateFromDays(-8))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .doFinally { view.hideLoading() }
            .subscribe({ list ->
                view.populateList(list)
            }, {
                view.populateList(utils.fakeList())
                view.showError(it)
            })

        disposables.add(posts)
    }

    override fun onStop() {
        disposables.clear()
    }
}