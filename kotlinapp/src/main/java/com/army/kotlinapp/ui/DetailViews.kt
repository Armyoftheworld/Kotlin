package com.army.kotlinapp.ui

import com.army.kotlinapp.Repo

/**
 * Created by Army on 2017/06/17.
 */
interface DetailViews : IViews {
    fun showRepo(repos: List<Repo>)
}