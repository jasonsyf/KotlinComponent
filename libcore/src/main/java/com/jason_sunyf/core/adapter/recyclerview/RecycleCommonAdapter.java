package com.jason_sunyf.core.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jason_Sunyf
 * @date 2017/11/23 0023
 * Email： jason_sunyf@163.com
 */

public  abstract class RecycleCommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas=new ArrayList<>();
    protected LayoutInflater mInflater;
    private SparseBooleanArray selectedItems;//记录选中的position

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public RecycleCommonAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        if (datas != null) {
            mDatas.addAll(datas) ;
        }
        selectedItems=new SparseBooleanArray();
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId, -1);
        setListener(parent, viewHolder, viewType);
        return viewHolder;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }


    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) {
                return;
        }
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    mOnItemClickListener.onItemClick(parent, v, mDatas.get(position), position);
                }
            }
        });


        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get(position), position);
                }
                return false;
            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        setViewData(position,holder, mDatas.get(position));

    }

    /**
     * 判读是否选中
     */
    public boolean isSelected(int position){
        return getSelectedItemPosition().contains(position);
    }

    /**
     * 切换选中或取消选中
     */
    public void switchSelectedState(int position){
        if(selectedItems.get(position, false)){
            selectedItems.delete(position);
        }else{
            selectedItems.put(position,true);
        }
        notifyItemChanged(position);
    }

    /**
     * 清除所有选中item的标记
     */
    public void clearSelectedState(){
        List<Integer> selection = getSelectedItemPosition();
        selectedItems.clear();
        for(Integer i : selection){
            notifyItemChanged(i);
        }
    }

    /**
     * 全选
     */
    public void selectAllItems(){
        clearSelectedState();
        for(int i = 0; i < getItemCount(); i++){
            selectedItems.put(i,true);
            notifyItemChanged(i);
        }
    }

    /**
     * 获取item数目
     */
    public int getSelectedItemCount(){
        return selectedItems.size();
    }

    /**
     * 获取选中的items
     */
    public List<Integer> getSelectedItemPosition(){
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for(int i = 0; i < selectedItems.size(); i++){
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }


    /**
     * 获取选中的items preorderNo
     */
    public List<T> getSelectedItem(){
        List<T> items = new ArrayList<>(selectedItems.size());
        for(int i = 0; i < selectedItems.size(); i++){
            items.add(mDatas.get(selectedItems.keyAt(i)));
        }
        return items;
    }
    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.size();
        }
        return 0;
    }

    public void update(List<T> data) {
        mDatas.clear();
        if (data != null) {
            mDatas.addAll(data);
        }
        notifyDataSetChanged();
    }

    public List<T> getData(){
        return mDatas;
    }

    public void append(List<T> response){
        if (response!=null){
            mDatas.addAll(response);
        }
        notifyDataSetChanged();
    }

    protected abstract void setViewData(int position, ViewHolder holder, T item);

    public interface OnItemClickListener<T> {
        void onItemClick(ViewGroup parent, View view, T t, int position);

        boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
    }


}