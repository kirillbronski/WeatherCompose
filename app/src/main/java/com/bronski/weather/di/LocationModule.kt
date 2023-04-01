package com.bronski.weather.di

import com.bronski.weather.data.location.DefaultLocationTracker
import com.bronski.weather.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindsLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker

}