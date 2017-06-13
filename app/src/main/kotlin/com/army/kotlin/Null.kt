package com.army.kotlin

/**
 * Created by Army on 2017/06/10.
 */
fun main(args: Array<String>) {
    test(null)
    test("12")
}

fun test(str: String?) {//加？表示可以传null
    val first = str?.substring(1)
    println("first = $first")
}

class Person(val age: Int, val name: String?, val pwd: String)

fun Person.save() {
    fun check(str: String): Boolean {//方法里面定义方法
//        if(str.isNullOrEmpty())
        if (str == null || str.isEmpty()) {
            return false
        }
        return true
    }
    class User(val str: String)//方法里面定义类
}