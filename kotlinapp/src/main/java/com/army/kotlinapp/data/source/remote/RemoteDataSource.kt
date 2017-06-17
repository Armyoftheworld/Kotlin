package com.army.kotlinapp.data.source.remote

import com.army.kotlinapp.Repo
import com.army.kotlinapp.Users
import com.army.kotlinapp.api.GithubService
import com.army.kotlinapp.data.source.IDataSource
import io.reactivex.Flowable

/**
 * Created by Army on 2017/06/16.
 */
class RemoteDataSource(val githubService: GithubService) : IDataSource {
    override fun getUsers(key: String): Flowable<Users> = githubService.getUsers(key)
    override fun getRepos(path: String): Flowable<List<Repo>> = githubService.getRepos(path)
}