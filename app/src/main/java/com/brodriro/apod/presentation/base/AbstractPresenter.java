package com.brodriro.apod.presentation.base;

import java.lang.ref.WeakReference;

public class AbstractPresenter <T extends MVPContract.BaseView> implements MVPContract.BasePresenter<T> {

    private WeakReference<T> view;

    @Override
    public void bindView(T view) {
        this.view = new WeakReference<T>(view);
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public T getView() {
        if (view == null) return null;
        return view.get();
    }

}