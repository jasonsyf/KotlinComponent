package com.jason_sunyf.core.adapter.listview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;


/**
 *
 * @author Jason_Sunyf
 * @date 2017/12/16 0016
 * Email： jason_sunyf@163.com
 */
public class BaseViewHolder implements View.OnClickListener{
    private SparseArray<View> mSparseArray = new SparseArray<>();

    private View mConvertView;

    private OnClickBack mOnClickBack;

    private int mPosition;

    public BaseViewHolder(View convertView, OnClickBack onClickBack
    ) {
        mConvertView = convertView;
        if (mConvertView != null) {
            mConvertView.setTag(this);
        }
        mOnClickBack = onClickBack;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    private <T extends View> T findView(int viewId) {
        View view = null;
        if (mConvertView != null) {
            view = mConvertView.findViewById(viewId);
        }
        if (view != null) {
            mSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public <T extends View> T getView(int viewId) {
        View view = mSparseArray.get(viewId);
        if (view != null) {
            return (T) view;
        }
        view = findView(viewId);
        return (T) view;
    }

    public BaseViewHolder setText(int viewId, CharSequence sequence) {
        TextView view = getView(viewId);
        if (view != null) {
            view.setText(sequence);
        }

        return this;
    }

    public BaseViewHolder setImageRes(int viewId, int imgResId) {
        ImageView view = getView(viewId);
        if (view != null) {
            view.setImageResource(imgResId);
        }
        return this;
    }

    public BaseViewHolder setSwitchState(int viewId, boolean isChecked) {
        Switch sw = getView(viewId);
        if (sw != null) {
            sw.setChecked(!isChecked);
        }
        return this;
    }


    public BaseViewHolder setOnClickListener(int viewId) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(this);
        }
        return this;
    }

    public BaseViewHolder setLineLayoutListener(int viewId) {
        LinearLayout layout = getView(viewId);
        if (layout != null) {
            layout.setOnClickListener(this);
        }
        return this;
    }



    //给一个imageView设置bitMap
    public BaseViewHolder setImageBipmap(Bitmap bitmap, int viewId) {
        if (bitmap == null) {
            return this;
        }
        View view = getView(viewId);
        if (view != null && view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(bitmap);
        }
        return this;
    }

    public BaseViewHolder setHint(int viewId, String var) {
        EditText editText = getView(viewId);
        if (editText != null) {
            editText.setHint(var);
        }
        return this;
    }

    //给一个imageView设置显示隐藏
    public BaseViewHolder setVisible(int viewId, boolean bool) {
        ImageView view = getView(viewId);
        if (bool) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
        return this;
    }



    public BaseViewHolder setTvVisible(int viewId, boolean bool) {
        TextView tv = getView(viewId);
        if (bool) {
            tv.setVisibility(View.VISIBLE);
        } else {
            tv.setVisibility(View.GONE);
        }
        return this;
    }


    //给一个textView设置text
    public BaseViewHolder setTextViewText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    //给一个textView加drawable
    public BaseViewHolder setTvDrawable(int textId, Drawable d, int location){
        TextView tv =getView(textId);

        d.setBounds(0, 0, d.getMinimumWidth(), d.getMinimumHeight());
        //左边 上边 右边 下边
        tv.setCompoundDrawables(d, null, null, null);
        return this;
    }

    public BaseViewHolder setTextViewTextColor(int viewId, int viewColor) {
        TextView textView = getView(viewId);
        textView.setTextColor(viewColor);
        return this;
    }

//    public View getView(int viewId) {
//
//    }
    public String getEdTextString(int viewId) {
        EditText editText = getView(viewId);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return editText.getText().toString();
    }

    public BaseViewHolder setBgColor(int LayoutId, int LayoutColor) {
        LinearLayout layout = getView(LayoutId);
        layout.setBackgroundResource(LayoutColor);
        return this;
    }

    public BaseViewHolder setTextViewBgColor(int LayoutId,int color){
        TextView textView =getView(LayoutId);
        textView.setBackgroundColor(color);
        return this;
    }

    public BaseViewHolder setChecked(int LayoutId,Boolean ischecked){
        CheckBox checkBox =getView(LayoutId);
        checkBox.setChecked(ischecked);
        return this;
    }

    public BaseViewHolder setOnclickListener(int viewId) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(this);
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        if (mOnClickBack != null) {
            mOnClickBack.onClickBack(mPosition, v, this);
        }
    }

}
