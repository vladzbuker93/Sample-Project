package com.vladzbuker.sampleproject.ui.activity

import android.os.Bundle
import android.widget.TextView
import com.vladzbuker.sampleproject.R
import com.vladzbuker.sampleproject.ui.activity.viewModel.MainActivityViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : DaggerActivity() {
    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_test)
    }
}