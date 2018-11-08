package com.army.kotlin

import java.io.File

/**
 * author：daijun
 * time：2018/11/7
 * description：
 */

fun main(args: Array<String>) {
    println("Port".toIntOrNull() ?: 0)

    var peopleList = arrayListOf(People(1, "1"), People(2, "2"), People(3, "3"))
    peopleList.print()
            //可以进行相应的操作之后并把当前集合返回，但是不能改变类型，这是与map的区别
            .onEach { people ->
                people.also {
                    it.age *= 2
                    it.name = ((it.name.toIntOrNull() ?: 0) * 2).toString()
                }
            }.print()
    peopleList.map { people ->
        "age = ${people.age} and name = ${people.name}"
    }.print()

    val file = File("settings.gradle")
    //不满足里面的条件执行return
    file.takeIf { it.exists() } ?: error("file not find")

    //采用了反向谓词。当它不满足谓词时返回接收者，否则返回null
    file.takeUnless { !it.exists() } ?: error("file not find")

    //分组求个数
    val content = "abclak;gdldljh;sosa;gh;agkeopr"
    println(content.groupingBy { it }.eachCount())
    var map = content.groupBy { it }.mapValues {
        it.value.size
    }
    map = map as MutableMap
    map['x'] = 1
    map['y'] = 1
    map['z'] = 1

    //按照key移除元素
    map = map.minus(arrayOf('x', 'y', 'z'))
    println(map)

    val list1 = listOf(1, 2, 3)
    val list2 = listOf(1, 2)
    println(minOf(list1.size, list2.size))
    println(maxOf(list1.size, list2.size))

    //相当于列表的输出的初始化
    val squares = List(5) { index -> index * index }
    val mutableList = MutableList(5) { 0 }
    println(squares)
    println(mutableList)

    val map2 = mapOf("key" to 1)
    //用这个mapDefault，如果调用getValue获取key对应的值找不到，不会抛出异常
    val mapDefault = map2.withDefault { it.length }
    println(map2["key2"])
    println(mapDefault.getValue("key2"))

    val array = arrayOf("a", "b", "c")
    array.contentToString().print()

}

data class People(var age: Int = 0, var name: String = "people")