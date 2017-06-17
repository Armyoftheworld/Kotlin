package com.army.kotlinapp.data.source

import com.army.kotlinapp.Repo
import com.army.kotlinapp.User
import io.reactivex.Flowable

/**
 * Created by Army on 2017/06/15.
 */
class DataManager(val remote: IDataSource, val local: IDataSource) {

    fun getUsers(key: String): Flowable<List<User>> =
            remote.getUsers(key).onErrorResumeNext(local.getUsers(key))
                    .map { it.items }

    fun getRepos(url: String): Flowable<List<Repo>> =
            remote.getRepos(url).onErrorResumeNext(local.getRepos(url))
                    .map { it }
}