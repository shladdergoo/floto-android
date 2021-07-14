package com.datagility.floto

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Floto : Application() {

    companion object {
        lateinit var instance: Floto

        fun getContext(): Context {
            return instance.applicationContext
        }
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
