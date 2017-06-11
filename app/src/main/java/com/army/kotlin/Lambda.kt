package com.army.kotlin

import android.view.View
import android.widget.Button

/**
 * Created by Army on 2017/06/10.
 * lambda
 */
fun main(args: Array<String>) {
    val action = { i: Int, j: Int -> println("i = $i, j = $j") }
    action(1, 2)

    val arraylist = arrayListOf<Int>(1, 2, 3)
    arraylist.forEach { value -> print(value) }

    val button: Button? = null
    val onclick = { view: View -> print("click") }
    button?.setOnClickListener(onclick)

}