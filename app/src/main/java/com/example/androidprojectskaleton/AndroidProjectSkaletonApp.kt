package com.example.androidprojectskaleton

import android.app.Application
import com.example.androidprojectskaleton.util.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidProjectSkaletonApp : Application() {
    
    override fun onCreate() {
        super.onCreate()
        Logger.init()
        Logger.i("Application started - BuildConfig.DEBUG: ${BuildConfig.DEBUG}")
    }
} 