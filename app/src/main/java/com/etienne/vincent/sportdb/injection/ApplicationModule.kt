package com.etienne.vincent.sportdb.injection

import android.content.Context
import android.content.SharedPreferences
import com.etienne.vincent.sportdb.data.local.LocalDataSource
import com.etienne.vincent.sportdb.data.local.LocalDataSourceImpl
import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.etienne.vincent.sportdb.data.remote.datasource.RemoteDataSource
import com.etienne.vincent.sportdb.data.remote.datasource.RemoteDataSourceImpl
import com.etienne.vincent.sportdb.data.remote.repository.SportDbRepositoryImpl
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository
import com.etienne.vincent.sportdb.domain.usecase.GetAllLeaguesUseCase
import com.etienne.vincent.sportdb.domain.usecase.GetAllTeamUseCase
import com.etienne.vincent.sportdb.domain.usecase.GetPlayersUseCase
import com.etienne.vincent.sportdb.presentation.players.PlayersPresenter
import com.etienne.vincent.sportdb.presentation.players.PlayersPresenterImpl
import com.etienne.vincent.sportdb.presentation.players.PlayersViewContract
import com.etienne.vincent.sportdb.presentation.teams.TeamsPresenter
import com.etienne.vincent.sportdb.presentation.teams.TeamsPresenterImpl
import com.etienne.vincent.sportdb.presentation.teams.TeamsViewContract
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


val presentationModule = module {
    //all presenters declared here
    factory<TeamsPresenter> { (viewContract: TeamsViewContract) -> TeamsPresenterImpl(viewContract, get(), get(), get()) }
    factory<PlayersPresenter> { (teamName: String, viewContract: PlayersViewContract) -> PlayersPresenterImpl(teamName, viewContract, get(), get()) }
}

val domainModule = module {
    //all domain use cases declared here, with factory scope
    factory { GetAllTeamUseCase(get()) }
    factory { GetAllLeaguesUseCase(get()) }
    factory { GetPlayersUseCase(get()) }
}

val dataModule = module {
    single { Gson() }

    single { createSharedPreferences(androidContext()) }

    single { createCache(androidContext()) }

    single { createOkHttpClient(androidContext(), get()) }

    single<CoroutineDispatcher> { Dispatchers.Main }

    single<SportsDbApi> { createWebService(get(), "https://www.thesportsdb.com/") }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<SportDbRepository> { SportDbRepositoryImpl(get(), get()) }


}




fun createCache(context: Context): Cache {
    val cacheSize: Long = 10 * 1024 * 1024 //10Mo
    return Cache(context.cacheDir, cacheSize)
}

fun createOkHttpClient(
    context: Context,
    cache: Cache
): OkHttpClient {
    val logger = HttpLoggingInterceptor()

    logger.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .cache(cache)
        .addNetworkInterceptor(logger)
        .build()
}


fun createSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences(
        "pref_key",
        Context.MODE_PRIVATE
    )
}


inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}