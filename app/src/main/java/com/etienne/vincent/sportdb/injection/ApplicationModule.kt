package com.etienne.vincent.sportdb.injection

import android.content.Context
import android.content.SharedPreferences
import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


val presentationModule = module {
    //all view model declared here
}

val domainModule = module {
    //all domain use cases declared here, with factory scope
}

val dataModule = module {
    single { Gson() }

    single { createSharedPreferences(androidContext()) }

    single { createCache(androidContext()) }

    single { createOkHttpClient(androidContext(), get()) }

    single<SportsDbApi> { createWebService(get(), "https://pokeapi.co/") }
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