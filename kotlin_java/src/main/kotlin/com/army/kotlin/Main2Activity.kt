package com.army.kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.army.java.JavaClass

class Main2Activity : Activity() {

    //类型构建对象时调用
    init {
        System.loadLibrary("kotlin-native")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //使用由kotlin关键字命名的方法或属性名
        JavaClass.`is`()
        JavaClass.`object`()

        JavaClass.array(intArrayOf(1, 2, 3))

        //*展开操作符
        JavaClass.array2(*intArrayOf(1, 2, 3))
        JavaClass.array2(1, 2, 3)

        //如果Java定义的函数的函数名在kotlin当中与操作符重载方法的方法名一致，则可以使用操作符调用相应的java方法
        val j = JavaClass()
        val k = j()//等于调用JavaClass里的invoke方法,k是Any类型的，如果想要使用Object的方法，需要如下这样写
        
//        val j2 = JavaClass() as java.lang.Object//这样的话，不能像上面j()这样调用了
//        j2.wait()

        val button: Button ?= null
        //SAM转换
        button?.setOnClickListener {
            //点击事件直接写
        }

        println(sum(1 ,2))

    }

    //相当于native方法
    external fun sum(x: Int, y: Int) :Int
}
