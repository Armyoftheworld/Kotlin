package com.army.kotlin

/**
 * Created by Army on 2017/06/10.
 */

//数据类，默认实现了equal方法和tostring方法
private data class MyPerson(var name: String, var age: Int)

//constructor可以去掉
private class Test constructor(name: String) {
    //类名后面的构造器是主构造器
    var age = 10
    var name = ""

    constructor(name: String, age: Int) : this(name) {//主构造器一定要实现
        this.name = name
        this.age = age
    }

    //初始化器, 能获取到主构造器的参数
    init {
        this.name = name
    }
}


fun main(args: Array<String>) {
    var person = MyPerson("army", 10)
    person.toString().print()
}