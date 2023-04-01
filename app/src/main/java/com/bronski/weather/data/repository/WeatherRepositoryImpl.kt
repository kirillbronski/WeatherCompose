package com.bronski.weather.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.bronski.weather.data.mappers.toWeatherInfo
import com.bronski.weather.data.remote.WeatherApi
import com.bronski.weather.domain.repository.WeatherRepository
import com.bronski.weather.domain.util.Resource
import com.bronski.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double,
    ): Resource<WeatherInfo> =
        runCatching {
            api.getWeatherData(latitude, longitude)
        }.fold(
            onSuccess = {
                Resource.Success(it.toWeatherInfo())
            },
            onFailure = {
                it.printStackTrace()
                Resource.Error(it.message ?: "An unknown error occurred")
            }
        )

}