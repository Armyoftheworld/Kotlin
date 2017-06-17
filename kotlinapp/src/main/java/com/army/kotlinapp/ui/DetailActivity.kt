package com.army.kotlinapp.ui

import android.support.v7.widget.LinearLayoutManager
import com.army.kotlinapp.BaseActivity
import com.army.kotlinapp.R
import com.army.kotlinapp.Repo
import com.army.kotlinapp.User
import com.army.kotlinapp.inject.component.AppComponent
import com.army.kotlinapp.inject.component.DaggerDetailActivityComponent
import com.army.kotlinapp.inject.module.DetailActivityModule
import com.bumptech.glide.Glide
import com.dongnao.kotlindy.ui.main.DetailAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailViews {
    lateinit var user: User

    lateinit var adapter: DetailAdapter

    @Inject
    lateinit var presenter: DetailPresenter

    override fun initViews() {
        user = intent.getParcelableExtra("user")
        Glide.with(this).load(user.avatar_url).into(detail_avatar)
        detail_name.text = user.name
        adapter = DetailAdapter(this)
        detailRecyclerView.layoutManager = LinearLayoutManager(this)
        detailRecyclerView.adapter = adapter
        presenter.getRepos(user.repos_url)
    }

    override fun attachLayoutId(): Int = R.layout.activity_detail

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerDetailActivityComponent.builder().appComponent(appComponent).detailActivityModule(DetailActivityModule(this)).build().inject(this)
    }

    override fun showRepo(repos: List<Repo>) {
        adapter.notifyDataSetChanged(repos)
    }
}
