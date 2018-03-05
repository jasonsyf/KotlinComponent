package com.jason_sunyf.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jason_sunyf.core.R;

/**
 *
 * @author Jason_Sunyf
 * @date 2017/11/8 0008
 * Email： jason_sunyf@163.com
 */

public class AppTitleBar extends RelativeLayout {
    private TextView mBack;
    private TextView mTitle;
    private TextView mAction;
    private TextView mAction1;
    private static final int DEFAULT_TITLE_COLOR = Color.BLACK;
    public AppTitleBar(Context context) {
        super(context);
        init(context, null);
    }
    public AppTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public AppTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }
    private void init(Context context, AttributeSet attr) {
        LayoutInflater.from(context).inflate(R.layout.app_title_bar, this);
        mBack = (TextView) findViewById(R.id.app_title_back);
        mTitle = (TextView) findViewById(R.id.app_title_text);
        mAction = (TextView) findViewById(R.id.app_title_action);
        mAction1 = (TextView) findViewById(R.id.app_title_action1);
        TypedArray array = context.obtainStyledAttributes(attr, R.styleable.AppTitleBar);
        if (array != null) {
            Drawable background = array.getDrawable(R.styleable.AppTitleBar_bar_background);
            if (background != null) {
                this.setBackgroundDrawable(background);
            }
            String title = array.getString(R.styleable.AppTitleBar_bar_title);
            int color = array.getColor(R.styleable.AppTitleBar_bar_title_text_color, DEFAULT_TITLE_COLOR);
            if (!TextUtils.isEmpty(title)) {
                mTitle.setText(title);
                mTitle.setTextColor(color);
            }
        } else {
            this.setBackgroundColor(Color.WHITE);
        }
        setTextAndImg(array, mBack, R.styleable.AppTitleBar_back_text, R.styleable.AppTitleBar_back_img);
        setTextAndImg(array, mAction, R.styleable.AppTitleBar_action_text, R.styleable.AppTitleBar_action_img);
        setTextAndImg(array, mAction1, R.styleable.AppTitleBar_action_text, R.styleable.AppTitleBar_action_img);
        if (array != null) {
            array.recycle();
        }
    }
    private void setTextAndImg(TypedArray array, TextView textView, int textId, int imgId) {
        if (array != null) {
            Drawable drawable = array.getDrawable(imgId);
            String backText = array.getString(textId);
            if (!TextUtils.isEmpty(backText)) {
                textView.setText(backText);
            }
            setDrawable(drawable, textView);
        } else {
            Drawable drawable = getResources().getDrawable(R.drawable.btn_selector);
            setDrawable(drawable, textView);
        }
    }
    private void setDrawable(Drawable drawable, TextView textView) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicWidth());
            textView.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public TextView getAction1() {
        return mAction1;
    }
    public void setAction1(TextView action1) {
        mAction1 = action1;
    }
    public TextView getAction() {
        return mAction;
    }
    public TextView getBack() {
        return mBack;
    }
    public TextView getTitle() {
        return mTitle;
    }
    public void setTitle(String text) {
        mTitle.setText(text);
    }
    public void setTitle(int text) {
        mTitle.setText(text);
    }
}
