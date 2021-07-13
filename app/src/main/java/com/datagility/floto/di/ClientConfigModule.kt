package com.datagility.floto.di

import com.datagility.floto.ClientConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ClientConfigModule {

    @Provides
    fun provideClientConfig(): ClientConfig {
        return ClientConfig()
    }
}
