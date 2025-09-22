package org.bryanollivie.project

import android.app.Application
import org.bryanollivie.project.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()

        //Init Koin
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApp)
            modules(appModule)
        }
    }
}