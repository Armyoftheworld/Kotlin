package com.army.kotlin

/**
 * Created by Army on 2017/06/10.
 */
interface OnTestClickListener {
    var name: String
    fun onClick()
    fun test() {
        print("OnTestClickListener")
    }
}

interface OnTestClickListener2 {
    var age: String
    fun onClick()
    fun test() {
        print("OnTestClickListener2")
    }
}

class MyClick(override var name: String, override var age: String) : OnTestClickListener, OnTestClickListener2 {
    override fun test() {
        //调用父类的test方法
        super<OnTestClickListener>.test()//调用OnTestClickListener里的方法
        super<OnTestClickListener2>.test()//调用OnTestClickListener2里的方法
    }

    override fun onClick() {
    }
}

abstract class Animal {
    abstract fun eat()
}

//一个类默认是final的，所以不能继承，要想继承普通的类，需要在父类前面加open
private open class Dog(override var name: String) : Animal(), OnTestClickListener {
    //继承抽象类要在抽象类后面加（）
    override fun onClick() {
    }

    override fun eat() {
    }

    open fun bark(){

    }
}

private class Husky(override var name: String) : Dog(name) {
    override fun onClick() {
        super.onClick()
    }

    override fun eat() {
        super.eat()
    }

    //想要重写父类的普通方法，需要给父类的方法加open
    override fun bark(){

    }
}

