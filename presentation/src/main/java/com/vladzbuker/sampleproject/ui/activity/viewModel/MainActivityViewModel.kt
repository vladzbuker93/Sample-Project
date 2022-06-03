package com.vladzbuker.sampleproject.ui.activity.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladzbuker.domain.usecase.TestCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel
@Inject constructor(
    private val testCase: TestCase
) : ViewModel() {

    fun testApi() {
        viewModelScope.launch { testCase.testApi() }
    }

}