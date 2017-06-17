package com.army.kotlinapp.ui

import android.support.v7.widget.LinearLayoutManager
import com.army.kotlinapp.BaseActivity
import com.army.kotlinapp.R
import com.army.kotlinapp.User
import com.army.kotlinapp.inject.component.AppComponent
import com.army.kotlinapp.inject.component.DaggerMainActivityComponent
import com.army.kotlinapp.inject.module.MainActivityModule
import com.army.kotlinapp.ui.MainAdapter.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject

class MainActivity : BaseActivity(), MainViews, OnItemClickListener {

    @Inject
    lateinit var presenter: MainPresenter

    lateinit var mainAdapter: MainAdapter

    override fun initViews() {
        mainAdapter = MainAdapter(this)
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainAdapter.onItemClickListener = this
        mainRecyclerView.adapter = mainAdapter
        mainSearch.onClick {
            val key = mainEdit.text.toString()
            presenter.getUsers(key)
        }

    }

    override fun attachLayoutId(): Int = R.layout.activity_main

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerMainActivityComponent.builder().appComponent(appComponent).mainActivityModule(MainActivityModule(this)).build().inject(this)
    }

    override fun showUsers(users: List<User>) {
        mainAdapter.notifyDataSetChanged(users)
    }

    override fun onItemClick(user: User) {
        startActivity(intentFor<DetailActivity>("user" to user))
    }
}
