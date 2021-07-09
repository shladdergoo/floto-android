package com.datagility.floto

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

class HttpNotesClient @Inject constructor() : NotesClient {

    override fun post(noteTest: String) {
        TODO("Not yet implemented")
    }
}
