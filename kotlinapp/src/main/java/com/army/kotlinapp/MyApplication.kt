package com.army.kotlinapp

import android.app.Application
import com.army.kotlinapp.inject.component.AppComponent
import com.army.kotlinapp.inject.component.DaggerAppComponent
import com.army.kotlinapp.inject.module.DataSourceModule

/**
 * Created by Army on 2017/06/17.
 */
class MyApplication : Application() {

    companion object {
        private lateinit var App: MyApplication

        fun getInstance(): MyApplication = App
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        App = this
        appComponent = DaggerAppComponent.builder().dataSourceModule(DataSourceModule()).build()
    }

    fun getAppComponent(): AppComponent = appComponent
}