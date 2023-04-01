package com.bronski.weather.domain.repository

import com.bronski.weather.domain.util.Resource
import com.bronski.weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(latitude: Double, longitude: Double): Resource<WeatherInfo>
}