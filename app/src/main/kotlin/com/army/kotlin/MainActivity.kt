package com.army.kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.coroutines.experimental.*
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onLongClick

class MainActivity : Activity(), AnkoLogger {

    @BindView(R.id.text)
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val job = launch(CommonPool) {
            delay(10_000)
            println("currentThread = ${Thread.currentThread()}")
            runOnUiThread { }
        }
//        job.cancel()
        launch(CommonPool) {
            job.join()//等job执行完了在执行当前线程里的方法
            delay(10_000)
            println("currentThread2 = ${Thread.currentThread()}")
            runOnUiThread { }
        }

        val async = async(CommonPool, CoroutineStart.LAZY) {
            //CoroutineStart.DEFAULT表示执行到25行就开始开启线程,CoroutineStart.LAZY表示只有调用await才开启线程
            //有返回值，用await可以获取到
            delay(5_000)
            "finish"
        }
        launch(CommonPool) {
            delay(5_000)
            async.await().print()
        }
        Dialog.show()

        ButterKnife.bind(this)

        text.text = "Army"
//---------------------------------------------------------anko---------------------------------------------------
        toast("hello")

        startActivity(intentFor<Main2Activity>("id".to(2)).newTask())
        startActivity<Main2Activity>("id" to 2)

        makeCall("110")

        info("log")
        debug("log")

        dip(1024)//获取的是px
        px2dip(1024)

        async(kotlinx.coroutines.experimental.android.UI) {
            val bg = bg {
                //此处为子线程
                getData()
            }
            //此处为UI线程
            showData(bg.await())
        }

        verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick { toast("Hello, ${name.text}!") }
            }
            textView("text") {
                lparams(100, 100)
                onClick {  }
                onLongClick {  }
            }
        }
    }

    fun getData(): String = ""
    fun showData(data: String) {}
}
