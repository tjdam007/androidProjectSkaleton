package com.example.androidprojectskaleton.util

import com.example.androidprojectskaleton.BuildConfig
import timber.log.Timber

object Logger {
    
    fun init() {
        if (BuildConfig.ENABLE_LOGGING) {
            Timber.plant(Timber.DebugTree())
        }
    }
    
    fun d(message: String, vararg args: Any?) {
        if (BuildConfig.ENABLE_LOGGING) {
            Timber.d(message, *args)
        }
    }
    
    fun i(message: String, vararg args: Any?) {
        if (BuildConfig.ENABLE_LOGGING) {
            Timber.i(message, *args)
        }
    }
    
    fun w(message: String, vararg args: Any?) {
        if (BuildConfig.ENABLE_LOGGING) {
            Timber.w(message, *args)
        }
    }
    
    fun e(message: String, vararg args: Any?) {
        if (BuildConfig.ENABLE_LOGGING) {
            Timber.e(message, *args)
        }
    }
    
    fun e(throwable: Throwable, message: String, vararg args: Any?) {
        if (BuildConfig.ENABLE_LOGGING) {
            Timber.e(throwable, message, *args)
        }
    }
} 