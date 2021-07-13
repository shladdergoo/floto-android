package com.datagility.floto.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(ActivityComponent::class)
class HttpClientModule {

    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient()
    }
}
