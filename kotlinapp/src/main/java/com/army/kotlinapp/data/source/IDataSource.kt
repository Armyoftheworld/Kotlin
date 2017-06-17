package com.army.kotlinapp.data.source

import com.army.kotlinapp.Repo
import com.army.kotlinapp.Users
import io.reactivex.Flowable

/**
 * Created by Army on 2017/06/15.
 */
interface IDataSource {
    fun getUsers(key: String): Flowable<Users>
    fun getRepos(path: String): Flowable<List<Repo>>
}