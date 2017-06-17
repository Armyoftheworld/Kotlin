package com.army.kotlinapp.inject.module

import com.army.kotlinapp.data.source.DataManager
import com.army.kotlinapp.ui.DetailActivity
import com.army.kotlinapp.ui.DetailPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Army on 2017/06/17.
 */
@Module
class DetailActivityModule(val views: DetailActivity) {

    @Provides
    fun providePresenter(dataManager: DataManager): DetailPresenter = DetailPresenter(views, dataManager)
}