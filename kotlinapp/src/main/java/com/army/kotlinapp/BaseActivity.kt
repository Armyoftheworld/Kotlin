package com.army.kotlinapp

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.army.kotlinapp.inject.component.AppComponent
import org.jetbrains.anko.indeterminateProgressDialog

/**
 * Created by Army on 2017/06/15.
 */
abstract class BaseActivity : AppCompatActivity() {

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(attachLayoutId())
        setUpComponent((application as MyApplication).getAppComponent())//两种写法一样
//        setUpComponent(MyApplication.getInstance().getAppComponent())
        initViews()
    }

    abstract fun initViews()

    abstract fun attachLayoutId(): Int

    abstract fun setUpComponent(appComponent: AppComponent)

    open fun startLoading() {
        if (null === progressDialog) {
            progressDialog = indeterminateProgressDialog("正在加载中...")
        } else {
            progressDialog?.show()
        }
    }

    open fun stopLoading() {
        progressDialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLoading()
    }
}