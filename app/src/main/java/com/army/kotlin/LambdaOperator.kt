package com.army.kotlin


/**
 * Created by Army on 2017/06/10.
 * 操作符重载
 */

class Rmb(val num: Int) {
    operator fun plus(rmb: Rmb): Int {
        return num + rmb.num
    }

    operator fun minus(rmb: Rmb): Int {
        return num - rmb.num
    }
}

fun main(args: Array<String>) {
    var num = Rmb(100) + Rmb(10)
    println(num)
    num = Rmb(100) - Rmb(10)
    print(num)
}