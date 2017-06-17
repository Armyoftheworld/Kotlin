package com.army.kotlinapp.inject.component

import com.army.kotlinapp.data.source.DataManager
import com.army.kotlinapp.inject.module.DataSourceModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Army on 2017/06/17.
 */
@Singleton
@Component(modules = arrayOf(DataSourceModule::class))
interface AppComponent {

    fun DataManager(): DataManager
}