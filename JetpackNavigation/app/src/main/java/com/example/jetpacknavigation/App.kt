package com.example.jetpacknavigation

import android.app.Application
import com.example.jetpacknavigation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule))
        }
    }

}
