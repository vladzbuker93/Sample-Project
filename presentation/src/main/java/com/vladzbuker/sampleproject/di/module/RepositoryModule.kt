package com.vladzbuker.sampleproject.di.module

import com.vladzbuker.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dataSource.api.WeatherApi
import repository.WeatherRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherApi: WeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi)
    }
}