package com.army.kotlin

/**
 * Created by Army on 2017/06/06.
 */
//顶层变量
val i: Int = 2;//final，（:Int）可以省略
var j = 3;
var k = "1";

//顶层函数
fun main(args: Array<String>): Unit {//默认返回类型是Unit，相当于void
    println("i = ${i},j = ${j}, k = ${k}")
    var user = User("Army");
    user.name = "";
    println(user.isMarried)
    user.age = 20;
    println(user.age)

    //相当于switch
    when (Color.RED) {
    //相当于case
        Color.BLUE -> println("blue")
        Color.RED,
        Color.YELLOW -> println("yellow")
    }

    when {
    /**
     * 相当于if（1 + 1 == 3）{print("1")} else if(max(1, 2) == 2){print("2")}
     */
        1 + 1 == 3 -> println("1")
        max2(1, 2) == 2 -> println("2")
    }

    //循环11次
    val range: IntRange = 0..10
    for(i in range){
        if(i == 9){
            continue
        }
        println(i)
    }
}

fun max(x: Int, y: Int) = if (x > y) x else y
//这两个方法等价
fun max2(x: Int, y: Int) = when {
    x > y -> x
    else -> y
}

fun fun1(): Int {
    return 1;
}

private class User(var name: String?) {
    //如果是val，则name不能修改，var反之
    val isMarried: Boolean//val变量可以写一个get获取器
        get() = true

    var age: Int = 0
        get() = field
        set(value) {
            field = value//用field必须给变量赋初值
        }
}

//enum 软关键字
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    YELLOW(1, 2, 3),
    BLUE(4, 5, 6);

    fun rgb() = r + g + b
}