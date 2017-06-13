package com.army.kotlin

import android.app.Application

/**
 * Created by Army on 2017/06/11.
 */
class MyApplication : Application(){
    companion object{
        lateinit private var app: Application

        fun getInstance() : Application = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}