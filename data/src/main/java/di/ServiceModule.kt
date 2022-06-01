package di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vladzbuker.data.BuildConfig
import dagger.Module
import dagger.Provides
import dataSource.api.WeatherApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit.Builder): WeatherApi {
        return retrofit.build().create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherService(
        okHttpClientBuilder: OkHttpClient.Builder,
        gson: Gson
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(okHttpClientBuilder.addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().apply {
                    addHeader("Authorization", BuildConfig.API_KEY)
                }.build())
            }.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .readTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)


    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()
}