package br.com.restaurant_online

import android.app.Application
import br.com.restaurant_online.component_domain.di.domainModule
import br.com.restaurant_online.component_network.di.networkModule
import br.com.restaurant_online.component_repository.di.repositoryModule
import br.com.restaurant_online.controller.NavigationControllerImpl
import com.restaurant_online.feature_home.presenter.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        configureKoin()
        NavigationControllerImpl.start()
    }

    private fun configureKoin() {
        startKoin {
            androidContext(this@Application)
            modules(listOf(
                networkModule,
                repositoryModule,
                domainModule,
                presenterModule,
            ))
        }
    }
}