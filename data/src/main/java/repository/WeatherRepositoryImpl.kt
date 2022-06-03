package repository

import android.util.Log
import com.vladzbuker.domain.repository.WeatherRepository
import dataSource.api.WeatherApi
import dto.common.onFailure
import dto.common.onSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import repository.base.BaseRepository
import javax.inject.Inject

class WeatherRepositoryImpl
@Inject constructor(
    private val weatherApi: WeatherApi
) : BaseRepository(), WeatherRepository {

    override suspend fun testApi(): Unit = withContext(Dispatchers.IO) {
        withCtxResult {
            weatherApi.getWeather()
        }.onFailure {
            Log.d("TEST_TEST", "Api Error")
        }.onSuccess {
            Log.d("TEST_TEST", "Success")
        }
    }

}