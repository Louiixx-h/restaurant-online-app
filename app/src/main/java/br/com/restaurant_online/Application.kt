package br.com.restaurant_online

import android.app.Application
import br.com.restaurant_online.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(appModules)
        }
    }
}