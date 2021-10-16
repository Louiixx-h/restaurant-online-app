package br.com.luishenrique.restaurantonline.di

import br.com.luishenrique.restaurantonline.data.network.RestaurantOnlineApi
import br.com.luishenrique.restaurantonline.data.repository.RestaurantOnlineRepository
import br.com.luishenrique.restaurantonline.ui.main.viewmodel.RestaurantViewModel
import br.com.luishenrique.restaurantonline.utils.BASE_URL
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

val retrofitModule = module {
    single<Retrofit> {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    single<RestaurantOnlineApi> {
        get<Retrofit>().create(RestaurantOnlineApi::class.java)
    }
}

val repositoryModule = module {
    single { RestaurantOnlineRepository(get()) }
}

val viewModelModule = module {
    viewModel { RestaurantViewModel(get()) }
}

val appModules = listOf(
    retrofitModule, repositoryModule, viewModelModule
)