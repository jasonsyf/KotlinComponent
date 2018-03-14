package com.sinotech.modulerxjava

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.item_list_gank.view.*

/**
 * @author : Jason_Sunyf
 * @date   : 2018年02月28日17时19分
 * E-mail  : jason_sunyf@163.com
 */
class GankAdapter(private val context: Context, private val data: MutableList<GankItem>?) : RecyclerView.Adapter<GankAdapter.ViewHodler>() {

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        with(holder.itemView!!) {
            item_gank_title?.text = data!![position].desc
            item_gank_date?.text = data[position].publishedAt
            item_gank_who?.text = data[position].who
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            ARouter.getInstance().build("/kotlin/GankDetailActivity")
                     .withString("url", data?.get(position)?.url).navigation(context)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHodler {
        return ViewHodler(View.inflate(parent?.context, R.layout.item_list_gank, null))
    }

    override fun getItemCount(): Int {
        if (data != null) {
            return data.size
        }
        return 0
    }

    class ViewHodler(item: View) : RecyclerView.ViewHolder(item)

    fun update(data1: MutableList<GankItem>) {
        data!!.clear()
        data.addAll(data1)
        notifyDataSetChanged()
    }


}


