package com.sinotech.modulerxjava

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * @author : Jason_Sunyf
 * @date   : 2018年03月14日17时12分
 * E-mail  : jason_sunyf@163.com
 */
class KotlinCommomAdapter<T>(val layoutId:Int,var items:List<T>,val init:(View,T)->Unit): RecyclerView.Adapter<KotlinCommomAdapter.ViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view,init)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder:ViewHolder<T>, position: Int) {
       holder.bindData(items[position])
    }

    class ViewHolder<in T>(view: View, val init: (View, T) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindData(item: T) {
            with(item) {
                init(itemView, item)
            }
        }
    }
}