package com.datagility.floto.di

import com.datagility.floto.ClientConfig
import com.datagility.floto.Floto
import com.datagility.floto.Property
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ClientConfigModule {

    @Provides
    fun provideClientConfig(): ClientConfig {

        val authority = Property.getProperty("api.root", Floto.getContext())
        val config = ClientConfig()
        config.authority = authority

        return config
    }
}
