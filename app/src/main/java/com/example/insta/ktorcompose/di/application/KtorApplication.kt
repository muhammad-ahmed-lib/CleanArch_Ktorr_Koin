package com.example.insta.ktorcompose.di.application

import android.app.Application
import com.example.insta.ktorcompose.di.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KtorApplicationA: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@KtorApplicationA)
            modules(appModule)
        }
    }
}