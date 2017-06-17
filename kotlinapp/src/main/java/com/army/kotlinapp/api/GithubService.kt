package com.army.kotlinapp.api

import com.army.kotlinapp.Repo
import com.army.kotlinapp.Users
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by Army on 2017/06/16.
 */
interface GithubService {

    @GET("search/users")
    fun getUsers(@Query("q") key: String) : Flowable<Users>

    @GET
    fun getRepos(@Url path:String):Flowable<List<Repo>>
}