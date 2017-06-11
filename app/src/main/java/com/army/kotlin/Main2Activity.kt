package com.army.kotlin

import android.app.Activity
import android.os.Bundle
import com.google.gson.Gson
import java.io.InputStreamReader

class Main2Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val inputStreamReader = InputStreamReader(assets.open("GPSTrace.txt"))
        val readLines = inputStreamReader.readLines()
        inputStreamReader.close()
        val gson = Gson()
        val data = readLines.map {
            gson.fromJson(it, Gps::class.java)
        }
        database.saveAll(data)
        for (gps in database.queryAll()) {
            gps.toString().print()
        }
    }
}
