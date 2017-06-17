package com.army.kotlinapp.ui

import com.army.kotlinapp.data.source.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Army on 2017/06/16.
 */
class MainPresenter(val views: MainViews, val dataManager: DataManager) {

    fun getUsers(key: String) {
        dataManager.getUsers(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { views.startLoading() }
                .doOnNext { views.stopLoading() }
                .subscribe { views.showUsers(it) }
    }
}