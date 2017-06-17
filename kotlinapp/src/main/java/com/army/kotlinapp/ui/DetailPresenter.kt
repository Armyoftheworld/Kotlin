package com.army.kotlinapp.ui

import com.army.kotlinapp.data.source.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Army on 2017/06/16.
 */
class DetailPresenter(val views: DetailViews, val dataManager: DataManager) {

    fun getRepos(url: String) {
        dataManager.getRepos(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { views.startLoading() }
                .doOnNext { views.stopLoading() }
                .subscribe { views.showRepo(it) }
    }
}