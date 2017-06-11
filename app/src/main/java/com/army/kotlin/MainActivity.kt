package com.army.kotlin

import android.app.Activity
import android.os.Bundle
import kotlinx.coroutines.experimental.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val job = launch(CommonPool){
            delay(10_000)
            println("currentThread = ${Thread.currentThread()}")
            runOnUiThread {  }
        }
//        job.cancel()
        launch(CommonPool){
            job.join()//等job执行完了在执行当前线程里的方法
            delay(10_000)
            println("currentThread2 = ${Thread.currentThread()}")
            runOnUiThread {  }
        }

        val async = async(CommonPool, CoroutineStart.LAZY){//CoroutineStart.DEFAULT表示执行到25行就开始开启线程,CoroutineStart.LAZY表示只有调用await才开启线程
            //有返回值，用await可以获取到
            delay(5_000)
            "finish"
        }
        launch(CommonPool){
            delay(5_000)
            async.await().print()
        }
        Dialog.show()
    }
}
