package com.army.kotlinapp.data.source.local

import com.army.kotlinapp.Repo
import com.army.kotlinapp.Users
import com.army.kotlinapp.data.source.IDataSource
import io.reactivex.Flowable

/**
 * Created by Army on 2017/06/15.
 */
class LocalDataSource : IDataSource {
    override fun getRepos(path: String): Flowable<List<Repo>> {
        return Flowable.just(arrayListOf())
    }

    override fun getUsers(key: String): Flowable<Users> {
        return Flowable.just(Users(arrayListOf()))
    }
}