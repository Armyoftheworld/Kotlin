package com.army.kotlinapp.inject.component

import com.army.kotlinapp.inject.module.DetailActivityModule
import com.army.kotlinapp.inject.scope.ActivityScope
import com.army.kotlinapp.ui.DetailActivity
import dagger.Component

/**
 * Created by Army on 2017/06/17.
 */
@ActivityScope
@Component(modules = arrayOf(DetailActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface DetailActivityComponent {
    fun inject(mainActivity: DetailActivity)
}