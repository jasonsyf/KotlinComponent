package com.jason_sunyf.core.adapter.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import java.util.ArrayList

/**
 * ListView通用适配器
 * @author jason_sunyf
 * @date 2017/11/1
 */
abstract class CommonAdapter<T>(context: Context, data: List<T>?, private val mLayoutId: Int) : BaseAdapter(), OnClickBack {
    private val mData = ArrayList<T>()
    private val mInflater: LayoutInflater

    val data: List<T>
        get() = mData

    init {
        if (data != null) {
            mData.addAll(data)
        }
        mInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun getItem(position: Int): T? {
        var t: T? = null
        if (position >= 0 && position < count) {
            t = mData[position]
        }
        return t
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var convertView = convertView
        val holder: BaseViewHolder
        if (convertView != null) {
            holder = convertView.tag as BaseViewHolder
        } else {
            convertView = mInflater.inflate(mLayoutId, parent, false)
            holder = BaseViewHolder(convertView, this)
            setListeners(holder, convertView, position)
        }
        holder.position = position
        setViewData(position, holder, getItem(position))
        return convertView
    }

    fun update(data: List<T>?) {
        mData.clear()
        if (data != null) {
            mData.addAll(data)
        }
        notifyDataSetChanged()
    }

    fun append(response: List<T>?) {
        if (response != null) {
            mData.addAll(response)
        }
        notifyDataSetChanged()
    }

    protected abstract fun setListeners(holder: BaseViewHolder, view: View?, position: Int)


    protected abstract fun setViewData(position: Int, holder: BaseViewHolder, item: T?)
}
