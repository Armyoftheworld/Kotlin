package com.army.kotlin

/**
 * Created by Army on 2017/06/10.
 */
fun main(args: Array<String>) {
    val packageName = "com.juziwl.xiaoxin"
    "----------------------------------------------------------------------".print()
    packageName.split(".").print()
    val path = "stroage/orange/data/bundle.gradle"
    val dir = path.substringBeforeLast("/")
    val fileName = path.substringAfterLast("/")
    "dir = $dir, fileName = $fileName".print()
    fileName.forEach {
        print("$it,")
    }
    "".print()
    "-------------------------------正则表达式----------------------------------".print()
    val regex = "(.+)/(.+)\\.(.+)".toRegex()
    var matchResult = regex.matchEntire(path)
    if(matchResult != null){
        matchResult.groups.forEach { print("$it,") }
        "".print()
        matchResult.groupValues.print()
        matchResult.destructured.toList().print()//我的理解是在字符串中，取/和.前后的值
    }

    val regex2 = """(.+)/(.+)\.(.+)""".toRegex()//三个引号的字符串\不用转义
    matchResult = regex2.matchEntire(path)
    if(matchResult != null){
        matchResult.destructured.toList().print()
    }
    "\$path".print()

    println("port = ${"PORT".toIntOrNull()?: 0}")
}

inline fun <E> List<E>.print() : List<E>{
    forEach { print("${it.toString()},") }
    println()
    return this
}
