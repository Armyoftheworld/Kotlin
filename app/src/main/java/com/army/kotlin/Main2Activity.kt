package com.army.kotlin

import android.app.Activity
import android.os.Bundle

class Main2Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        val inputStreamReader = InputStreamReader(assets.open("GPSTrace.txt"))
//        val readLines = inputStreamReader.readLines()
//        inputStreamReader.close()
//        val gson = Gson()
//        val data = readLines.map {
//            gson.fromJson(it, Gps::class.java)
//        }
//        database.saveAll(data)
        database.deleteById(942)
        database.updateById(941)
        val list = database.queryAll()
        for (gps in list) {
            gps.toString().print()
        }

//        database.queryLng(800).forEachIndexed { index, d -> "_id = ${index}, lng = ${d}".print() }
    }
}
