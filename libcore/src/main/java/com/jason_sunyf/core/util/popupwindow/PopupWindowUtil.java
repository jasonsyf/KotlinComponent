package com.jason_sunyf.core.util.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.jason_sunyf.core.R;

/**
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */
public abstract class PopupWindowUtil implements PopupWindow.OnDismissListener {
    private PopupWindow mPopupWindow;
    private Window mWindow;
    private OnPopWindowDisMisBack mOnPopWinDisMisBack;
    public boolean outSideWindow;

    public PopupWindowUtil(Context context, int LayoutId, int width, int height, OnPopWindowDisMisBack onPopWinDisMisBack) {
        initView(context, LayoutId, width, height);
        mOnPopWinDisMisBack = onPopWinDisMisBack;
    }

    public PopupWindowUtil(Window window, Context context, int LayoutId, int width, int height) {
        initView(context, LayoutId, width, height);
        mWindow = window;
    }

    private void initView(Context context, int LayoutId, int width, int height) {
        mPopupWindow = new PopupWindow(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View BgView = inflater.inflate(LayoutId, null);

        //为了去掉popWin周围默认黑色的边框
        Drawable drawable = new ColorDrawable(Color.WHITE);
        mPopupWindow.setBackgroundDrawable(drawable);
        mPopupWindow.setContentView(BgView);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setWidth(width);
        mPopupWindow.setHeight(height);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setOnDismissListener(this);
        //这个方法传了一个view布局 可以在view上找到对应的控件 并赋值
        setData(BgView);
    }

    //在弹出popWindow时给背景window添加一个背景
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        mWindow.setAttributes(lp);
    }

    public abstract void setData(View view);


    //判断popWindow是否正在显示
    public boolean isShow() {
        return mPopupWindow.isShowing();
    }

    //*******************************控制popWindow的显示于隐藏**************************//

    //将popWindow显示到指定view控件下方
    public void showAsParentView(View view) {
//        if (mWindow!=null){
//            setBackgroundAlpha(0.6f);
//        }
        if (view != null) {
            mPopupWindow.showAsDropDown(view);
        }
    }


    //将popWindow从屏幕下方弹出来
    public void showAsDownWindow(View parentView) {
        if (outSideWindow) {
            mPopupWindow.setFocusable(false);
            mPopupWindow.setOutsideTouchable(false);
        }
        //默认从底部弹出来的popWindow 加了动画
        //该动画是popWindow从底部弹出时需要加的动画
        mPopupWindow.setAnimationStyle(R.style.popwindow_anim_style);
        mPopupWindow.showAtLocation(parentView,
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        if (mWindow != null) {
            setBackgroundAlpha(1.0f);
        }
    }

    //将popWindow显示到指定的x y坐标   parentView为popWin的背景view
    public void showAsXYPoint(View parentView, int x, int y) {
        //    mPopupWindow.setAnimationStyle(R.style.AnimationLeftFade);
        mPopupWindow.showAsDropDown(parentView, x, y);
    }

    //让popWindow dismiss
    public void dismissWindow() {
        mPopupWindow.dismiss();
    }

    @Override
    public void onDismiss() {
        mOnPopWinDisMisBack.onPopWindowDismiss();
    }
}