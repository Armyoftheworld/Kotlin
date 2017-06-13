package com.army.kotlin

import android.view.View

/**
 * Created by Army on 2017/06/11.
 * 泛型，kotlin没有super，extends通配符
 */

//这些跟Java一样
class MyClass1<T> {}

fun <T> getNyClass(t: T) {
}

//不一样
class MyClass2<in T> {
    fun setValue(t: T) {
        //如果泛型前面有in，则这个泛型只能用来赋值，不能取值
    }
}

class MyClass3<out T> {
//    fun getVales(): T{
//        //如果泛型前面有out，则这个泛型只能用来取值，不能赋值
//        val v: T by Delegates.notNull<T>()
//        return v
//    }
}

//泛型约束，只能传冒号后面的类型的对象，这是添加一个约束
fun <T: Number> put(t: T){

}

//这是添加多个约束，而且传的值必须同时继承了这些约束
//这里表示传入的对象必须同时实现OnClickListener和OnLongClickListener接口
fun <T> put2(t: T) where T: View.OnClickListener, T: View.OnLongClickListener{

}

fun main(args: Array<String>) {
    //kotlin泛型里的*代表Java的？，表示任意的类型
    val list: ArrayList<*> = arrayListOf(1, 2, 3)
}
