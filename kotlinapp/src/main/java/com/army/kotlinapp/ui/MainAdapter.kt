package com.army.kotlinapp.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.army.kotlinapp.R
import com.army.kotlinapp.User
import com.bumptech.glide.Glide
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Army on 2017/06/17.
 */
class MainAdapter(val context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val users: ArrayList<User> = arrayListOf()

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        val user = users[position]
        Glide.with(context).load(user.avatar_url).into(holder?.user_avatar)
        holder?.user_home?.text = user.html_url
        holder?.user_name?.text = user.name
        holder?.user_scope?.text = user.score.toString()
        holder?.itemView?.onClick { onItemClickListener?.onItemClick(user) }
    }

    fun notifyDataSetChanged(items: List<User>) {
        users.clear()
        users.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.adapter_user_item, parent, false))
    }

    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val user_avatar: ImageView = view.find(R.id.user_avatar)
        val user_name: TextView = view.find(R.id.user_name)
        val user_scope: TextView = view.find(R.id.user_scope)
        val user_home: TextView = view.find(R.id.user_home)
    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(user: User)
    }
}