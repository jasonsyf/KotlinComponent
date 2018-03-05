package com.jason_sunyf.core.adapter.viewpage;

import android.support.v4.app.FragmentManager;


import com.jason_sunyf.core.base.BaseFragment;

import java.util.List;


/**
 * @author jason_syf
 * @date 2017/11/3
 * Email:jason_sunyf@163.com
 */

public class TablayoutPagerAdapter extends ViewPagerAdapterForFg {
    private List<String> mList;

    public TablayoutPagerAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> list) {
        super(fm, fragments);
        mList = list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);//页卡标题
    }

}
