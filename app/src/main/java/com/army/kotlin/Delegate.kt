package com.army.kotlin

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Army on 2017/06/10.
 * 委托 替代继承的方式
 */
//类似于MyList继承的父类的方法全部指向ArrayList<String>的方法
class MyList(list: ArrayList<String>) : Collection<String> by list

fun main(args: Array<String>) {
    var list = arrayListOf<String>()
    var mylist = MyList(list)
    mylist.forEach { }

    //类似于初始化
    val list1: ArrayList<String> by lazy { ArrayList<String>() }

    var str: String by Delegates.notNull<String>()

    //可以检测值的改变
    var str1: String by Delegates.observable("") {
        property, oldValue, newValue ->
        "property = ${property.name} oldValue = $oldValue newValue = $newValue".print()
    }
    str1 = "army"

    //可以检测值的改变，并且可以通过返回的boolean值判断是否赋值
    var str2: String by Delegates.vetoable("army") {
        property, oldValue, newValue ->
        !newValue.isNullOrEmpty()
    }
    str2 = ""
    str2.print()
}

var p : String by MyDelegate<String>()

class MyDelegate<T> : ReadWriteProperty<Any?, T> {
    var t: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return t ?: throw NullPointerException("")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        t = value
    }
}