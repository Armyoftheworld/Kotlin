package com.army.kotlin

import kotlinx.reflect.lite.ReflectionLite

/**
 * Created by Army on 2017/06/11.
 * 注解与反射
 * 要使用反射，必须依赖kotlinx.reflect.lite这个库，但是我发现这个库好像还有问题，我不能反射获取到系统的类，只能获取到自定义的类
 */

@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MyPath

@MyPath class UsePath(val p: String){
    fun test(value: Int) : Int{
        return 1
    }
}

@MyPath fun getPath() {
}

var name = "army"
fun main(args: Array<String>) {
    //获取Class<?>对象
    String::class.java

    //只要接受一个参数并且没有返回值就可以传递函数名，前提是函数支持这种写法
    //这叫函数引用
    listOf(1, 2, 3).forEach(::println)

    //属性引用
    val p = ::name
    //因为引用的是var类型
    p.set("")
    p.get()

    //获取类里面属性的引用
    UsePath::p.get(UsePath("army"))//传入类的实例对象
    reflect()
}

fun reflect() {
    val klass = UsePath::class.java
    val klassMateData = ReflectionLite.loadClassMetadata(klass) ?: error("No class metadata found for $klass")
    val method = klass.getMethod("test", Int::class.java)
    val methodMetadata = klassMateData.getFunction(method) ?: error("No function metadata found for $method")
    methodMetadata.parameters.forEach{ println("name = ${it.name}, type = ${it.type}")}

}