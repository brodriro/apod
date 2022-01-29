package com.brodriro.apod.presentation.apods

import android.os.Bundle
import com.brodriro.apod.R
import com.brodriro.apod.presentation.base.BaseDaggerActivity

class ApodActivity : BaseDaggerActivity<ApodContract.Presenter>(), ApodContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun getLayout(): Int = R.layout.activity_main
}