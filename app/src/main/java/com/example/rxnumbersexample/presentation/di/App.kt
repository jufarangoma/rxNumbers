package com.example.rxnumbersexample.presentation.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(mainUC)
            modules(mainViewModel)
        }
    }

    init {
        instance = this
    }
    companion object {
        private var instance: App? = null
        fun applicationContext(): App {
            return instance!!
        }
    }
}