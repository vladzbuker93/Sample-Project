package repository

import com.vladzbuker.domain.repository.WeatherRepository
import dataSource.api.WeatherApi
import repository.base.BaseRepository
import javax.inject.Inject

class WeatherRepositoryImpl
@Inject constructor(
    private val weatherApi: WeatherApi
) : BaseRepository(), WeatherRepository {

}