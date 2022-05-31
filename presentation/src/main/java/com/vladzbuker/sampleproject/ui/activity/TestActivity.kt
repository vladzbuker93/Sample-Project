package com.vladzbuker.sampleproject.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.vladzbuker.domain.usecase.TestCase
import com.vladzbuker.sampleproject.R
import com.vladzbuker.sampleproject.ui.activity.viewModel.TestActivityViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject

class TestActivity : DaggerActivity() {
    @Inject
    lateinit var viewModel: TestActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_test)

        findViewById<TextView>(R.id.textView)?.text = viewModel.getTestValue()
    }
}