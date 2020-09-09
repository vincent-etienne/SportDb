package com.etienne.vincent.sportdb.injection

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class SportsDbApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SportsDbApplication)
            modules(
                listOf(
                    dataModule,
                    presentationModule,
                    domainModule
                )
            )

            if (BuildConfig.DEBUG) {
                androidLogger()
            }
        }
    }
}