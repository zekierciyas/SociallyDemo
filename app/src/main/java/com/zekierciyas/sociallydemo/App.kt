package com.zekierciyas.sociallydemo

import android.app.Application
import com.zekierciyas.socialappdemo.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant


@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            if (BuildConfig.DEBUG) {
                plant(Timber.DebugTree())
            }
        }
    }
}