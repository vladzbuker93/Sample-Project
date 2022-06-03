package dataSource.api

import retrofit2.http.GET

interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(): Any

}