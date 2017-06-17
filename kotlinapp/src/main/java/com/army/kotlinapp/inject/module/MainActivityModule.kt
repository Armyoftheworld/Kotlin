package com.army.kotlinapp.inject.module

import com.army.kotlinapp.data.source.DataManager
import com.army.kotlinapp.ui.MainActivity
import com.army.kotlinapp.ui.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Army on 2017/06/17.
 */
@Module
class MainActivityModule(val views: MainActivity) {

    @Provides
    fun providePresenter(dataManager: DataManager): MainPresenter = MainPresenter(views, dataManager)
}