package com.brodriro.apod.presentation.base;


import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDaggerActivity<T extends MVPContract.BasePresenter> extends DaggerAppCompatActivity
        implements MVPContract.BaseView {
    @Inject
    public T presenter;


    public BaseDaggerActivity() {
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayout());
        this.presenter.bindView(this);
    }

    protected void onDestroy() {
        if (this.presenter != null) {
            this.presenter.unbindView();
            this.presenter = null;
        }
        super.onDestroy();
    }

    @LayoutRes
    protected abstract int getLayout();
}