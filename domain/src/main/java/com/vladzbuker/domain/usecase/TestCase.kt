package com.vladzbuker.domain.usecase

import com.vladzbuker.domain.repository.WeatherRepository
import javax.inject.Inject

class TestCase
@Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    suspend fun testApi() {
        weatherRepository.testApi()
    }
}