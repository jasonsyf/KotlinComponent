package com.jason_sunyf.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jason_sunyf.core.R;

/**
 * 分割线
 * Created by jerry on 2017/11/2.
 */

public class MyDividerDecoration extends RecyclerView.ItemDecoration {
    private int mDividerHeight = 2;
    /**
     * 分割线画笔
     */
    private Paint mDividerPaint;

    public MyDividerDecoration(Context context) {
        mDividerPaint = new Paint();
        mDividerPaint.setColor(context.getResources().getColor(R.color.colorGray));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = mDividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + mDividerHeight;
            c.drawRect(left, top, right, bottom, mDividerPaint);
        }
    }
}
