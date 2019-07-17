package com.quevisiter.quevisiter
import android.app.Activity
import  android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

import com.quevisiter.quevisiter.common.network.RetrofitService

import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class QueVisiter : Application() {

    override fun onCreate() {

        super.onCreate()


        // Init Koin
        var appModule = module {
            single { RetrofitService() }
        }
        startKoin {
            androidLogger()
            androidContext(this@QueVisiter)
            modules(appModule)
        }
    }


}
@GlideModule
class AppGlideModule : com.bumptech.glide.module.AppGlideModule()