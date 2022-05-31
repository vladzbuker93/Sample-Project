package com.vladzbuker.domain.usecase

import com.vladzbuker.domain.repository.TestRepo
import javax.inject.Inject

class TestCase
@Inject constructor(
    private val testRepo: TestRepo
) {

    fun getTestValue(): String {
        return testRepo.getSomeData()
    }

}