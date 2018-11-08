package com.army.kotlin

/**
 * Created by Army on 2017/06/06.
 */
fun main(args: Array<String>) {
    var list = listOf(1, 2, 3, 4);
//    var list = arrayListOf<Int>(1, 2, 3, 4);
    println(list[0])
    println(list.last())
    for (it in list) {
        println(it)
    }
    list.forEach {
//        println(it)或者
        item ->
        println(item)
    }
    list.forEachIndexed { index, i -> println("index = ${index}, i = ${i}") }

    println(list.joinToString())

    test()
    test(1)
    test(j = "end")
    test(1, "end")
    test(1, 2, 3)

    "This is a inline function".print()
    var str = "this"
    println(str.lastChar)

    val map = mapOf(1 to "a", 2 to "b", "c" to 3)
    println(map[1])
    println(map["c"])

    //中缀调用
    1 to "a"
    //普通调用
    1.to("a")

    "a" with "b"

    val pair = "a" to "b"
    val (key, value) = pair//析构声明

    val compile = "com.android.support.test.espresso:espresso-core:2.2.2"//析构声明
    val (name, group, version) = compile.split(":")
    println("name=$name, group=$group, version=$version")
}

//中缀
infix fun <A, B> A.with(that: B): Pair<A, B> = Pair(this, that)

//给String类型的变量设置内联函数
inline fun String.print() {
    println(toString())
}

inline val String.lastChar: Char
    get() = get(length - 1)


fun test(i: Int = 100, j: String = "init") {//赋默认值
    println("i == ${i}, j == ${j}")
}

/**
 * 相当于java的test(int... item)
 */
fun test(vararg item: Int) {
    item.forEach { println("test${it}") }
}