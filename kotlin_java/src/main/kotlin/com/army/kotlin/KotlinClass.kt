@file:JvmName("NewKotlinClass")//修改类名，名字不能重复
@file:JvmMultifileClass

//除非用这个注解，可以把相同类名下的方法合并
package com.army.kotlin

import java.io.IOException

/**
 * Created by Army on 2017/06/13.
 */
var name = "";

//const == public static final
const val name1 = "";

fun kotlin() {

}

fun String.test() {

}

fun Int.test() {

}

@JvmName("test1") //必须加这个，不然编译不通过
fun List<String>.test3() {
}

fun List<Int>.test2() {
}

fun main(args: Array<String>) {
    listOf(1, 2).test2()
    listOf("", "").test3()
    A("").name
    B("").name
}

class A(val name: String) {

}

class B(name: String) {
    //JvmField 表示可以在Java中具有与kotlin一样的可见性
    @JvmField val name = name

    companion object C {
        val age = 1
        val marry = ""
    }
}

object D {
    val name = ""
}

@JvmOverloads //在Java中生成多个方法(不能只传后面的参数)，不然必须传两个参数
fun getDefault(name: String = "army", age: Int = 1) {

}

@Throws(IOException::class) //不加这句话，Java不会要求捕获异常
fun ex() {
    throw IOException("null")
}
