package com.jason_sunyf.core.adapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ListView通用适配器
 * @author jason_sunyf
 * @date 2017/11/1
 */
public abstract class CommonAdapter<T> extends BaseAdapter implements OnClickBack{
    private List<T> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private int mLayoutId;

    public CommonAdapter(Context context, List<T> data, int layoutId) {
        if (data != null) {
            mData.addAll(data);
        }
        mLayoutId = layoutId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        T t = null;
        if (position >= 0 && position < getCount()) {
            t = mData.get(position);
        }
        return t;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        BaseViewHolder holder;
        if (convertView != null) {
            holder = (BaseViewHolder) convertView.getTag();
        } else {
            convertView = mInflater.inflate(mLayoutId, parent, false);
            holder = new BaseViewHolder(convertView,this);
            setListeners(holder,convertView,position);
        }
        holder.setPosition(position);
        setViewData(position,holder,getItem(position));
        return convertView;
    }

    public void update(List<T> data) {
        mData.clear();
        if (data != null) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public List<T> getData(){
        return mData;
    }

    public void append(List<T> response){
        if (response!=null){
            mData.addAll(response);
        }
        notifyDataSetChanged();
    }

    protected abstract void setListeners(BaseViewHolder holder, View view, int position);


    protected abstract void setViewData(int position, BaseViewHolder holder, T item);
}
