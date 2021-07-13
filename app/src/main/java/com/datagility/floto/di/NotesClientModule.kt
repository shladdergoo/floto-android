package com.datagility.floto.di

import com.datagility.floto.HttpNotesClient
import com.datagility.floto.NotesClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NotesClientModule {
    @Binds
    abstract fun bindNotesClient(httpNotesClient: HttpNotesClient): NotesClient
}
