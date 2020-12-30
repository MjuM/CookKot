package com.example.monappli.injection

import android.app.Application
import android.app.Presentation
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App4A :   Application(){

    override fun onCreate(){
        super.onCreate()
        startKoin {
            // Android context
            androidContext(this@App4A)
            // modules
            modules(presentationModule, domainModule, dataModule)

        }
    }
}