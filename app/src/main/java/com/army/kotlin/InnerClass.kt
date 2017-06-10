package com.army.kotlin

import android.view.View

/**
 * Created by Army on 2017/06/10.
 */

//作用域
//public    默认的，所有地方可见
//private   类内部和同文件当中可见{
//private class P1
//private class P2{
//    constructor(){
//        val p1 = P1()
//    }
//}
// }
//protexted 子类内部可见
//internal  同module可见, jar里的类如果用internal修饰，则引入jar的项目不能访问该类

private class AlertDialog {
    //伴生类
    companion object B {
        fun test() {

        }
    }

    var str = "test"

    //嵌套类
    class Build {
        //获取不到str
    }

    inner class Inner {
        fun test() {
            str.substring(0)
        }
    }
}

//object相当于static
object Dialog {
    fun show() {

    }
}

fun main(args: Array<String>) {
    Dialog.show()
    AlertDialog.B.test()//如果伴生类没有名字，直接用Companion
//    AlertDialog.Companion.test()

    val animal = object : Animal() {
        //匿名内部类
        override fun eat() {
        }

    }

    //这种写法貌似只支持Android原生的接口
    val listener = View.OnClickListener {
        //如果接口只有一个方法,并且该方法只有一个参数，可以直接在花括号里写方法的实现内容
        //用it获取传参
        it.invalidate()
    }

}

interface onMyClickListener{
    fun test(i: Int, j: Int)
}