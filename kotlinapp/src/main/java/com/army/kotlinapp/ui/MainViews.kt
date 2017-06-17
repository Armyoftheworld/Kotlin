package com.army.kotlinapp.ui

import com.army.kotlinapp.User

/**
 * Created by Army on 2017/06/17.
 */
interface MainViews : IViews {
    fun showUsers(users: List<User>)
}