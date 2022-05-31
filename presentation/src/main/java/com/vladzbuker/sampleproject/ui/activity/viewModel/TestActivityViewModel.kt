package com.vladzbuker.sampleproject.ui.activity.viewModel

import androidx.lifecycle.ViewModel
import com.vladzbuker.domain.usecase.TestCase
import javax.inject.Inject

class TestActivityViewModel
@Inject constructor(
    private val testCase: TestCase
) : ViewModel() {

    fun getTestValue(): String {
        return testCase.getTestValue()
    }

}