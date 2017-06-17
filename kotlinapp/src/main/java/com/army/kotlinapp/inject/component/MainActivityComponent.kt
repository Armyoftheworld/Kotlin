package com.army.kotlinapp.inject.component

import com.army.kotlinapp.inject.module.MainActivityModule
import com.army.kotlinapp.inject.scope.ActivityScope
import com.army.kotlinapp.ui.MainActivity
import dagger.Component

/**
 * Created by Army on 2017/06/17.
 */
@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}