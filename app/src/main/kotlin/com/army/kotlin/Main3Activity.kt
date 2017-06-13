package com.army.kotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.recyclerview.v7.recyclerView

class Main3Activity : AppCompatActivity() {

    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main3)
        val items = ArrayList<Resp>()
        adapter = MyAdapter(this, items)
        verticalLayout {
            lparams {
                padding = 0
                margin = 0
            }
            recyclerView {
                layoutManager = LinearLayoutManager(this@Main3Activity)
                padding = dip(20)
                adapter = this@Main3Activity.adapter
            }
        }

        async(kotlinx.coroutines.experimental.android.UI){
            val deferred = bg {
                val input = assets.open("data.json")
                val readBytes = input.readBytes()
                input.close()
                Gson().fromJson<ArrayList<Resp>>(String(readBytes), getType<ArrayList<Resp>>())
            }
            items.clear()
            items.addAll(deferred.await())
            adapter.notifyDataSetChanged()
        }
    }
}

inline fun <reified T> getType() = object : TypeToken<T>(){}.type

class RecycleUI: AnkoComponent<MyAdapter>{
    override fun createView(ui: AnkoContext<MyAdapter>): View = kotlin.with(ui){
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            imageView{
                id = R.id.iv
                lparams{
                    rightMargin = dip(4)
                    width = dip(100)
                    height = dip(80)
                }
            }
            verticalLayout {
                textView {
                    id = R.id.tv1
                }
                textView {
                    id = R.id.tv2
                }
            }
        }
    }
}

class MyAdapter(val ctc: Context, var items: ArrayList<Resp>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val myViewHolder = MyViewHolder(RecycleUI().createView(AnkoContext.Companion.createReusable(ctc, this)))
        return myViewHolder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val resp = items[position]
        Glide.with(ctc).load(resp.owner?.avatar_url).into(holder?.iv)
        holder?.tv1?.text = resp.name
        holder?.tv2?.text = resp.full_name
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val iv = itemView.find<ImageView>(R.id.iv)
        val tv1 = itemView.find<TextView>(R.id.tv1)
        val tv2 = itemView.find<TextView>(R.id.tv2)
    }
}
