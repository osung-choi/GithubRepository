package com.osung.githubrepository

import android.app.Application
import com.osung.githubrepository.di.networkModule
import com.osung.githubrepository.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(viewModelModule, networkModule)
        }
    }
}