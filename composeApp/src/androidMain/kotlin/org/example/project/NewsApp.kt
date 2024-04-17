package org.example.project

import android.app.Application
import di.dataSourceModule
import di.netWorkModule
import di.repositoryModule
import di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class NewsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@NewsApp)
            androidLogger()
            modules(netWorkModule, dataSourceModule, repositoryModule, viewModelModule())
        }
    }
}