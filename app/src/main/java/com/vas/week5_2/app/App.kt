package com.vas.week5_2.app

import android.app.Application
import com.vas.feature_details_screen.di.DetailsDepsStore
import com.vas.feature_main_screen.di.MainDepsStore
import com.vas.week5_2.di.AppComponent
import com.vas.week5_2.di.DaggerAppComponent

class App : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()

        MainDepsStore.deps = appComponent
        DetailsDepsStore.deps = appComponent
    }
}