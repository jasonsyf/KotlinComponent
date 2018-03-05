package com.jason_sunyf.core.util;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


import com.jason_sunyf.core.R;
import com.jason_sunyf.core.base.BaseFragment;

import java.util.List;

/**
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */
public class ShowFragmentUtils {

    private ShowFragmentUtils() {

    }

    public static void showFragment(
            FragmentActivity activity,
            Class<? extends BaseFragment> who,
            String tag,
            Bundle arguments,
            boolean isAddToBackStack) {
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment fragment = null;

        try {
            fragment = who.newInstance();
        } catch (Exception e) {
            Log.e("showFragment", e.getMessage());
        }

        if (fragment == null) {
            Log.e("showFragment", "fragment is Null !!!");
            return;
        }

        fragment.setArguments(arguments);
        //系统的动画
//         transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//
        transaction.setCustomAnimations(
                R.anim.fragment_right_in,
                R.anim.fragment_right_out,
                R.anim.fragment_pop_in,
                R.anim.fragment_pop_out);

        transaction.add(android.R.id.content, fragment, tag);

        if (isAddToBackStack) {
            transaction.addToBackStack(tag);
        }

        transaction.commitAllowingStateLoss();
    }


    public static void addFragment(
            FragmentActivity activity,
            Class<? extends BaseFragment> who,
            String tag
       ) {
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment fragment = null;

        try {
            fragment = who.newInstance();
        } catch (Exception e) {
            Log.e("showFragment", e.getMessage());
        }

        if (fragment == null) {
            Log.e("showFragment", "fragment is Null !!!");
            return;
        }


        transaction.add(android.R.id.content, fragment, tag);


    }

    public static void popBackStack(FragmentActivity activity) {
        FragmentManager manager = activity.getSupportFragmentManager();
        manager.popBackStack();
    }

    public static BaseFragment getCurrentFragment(FragmentActivity activity) {
        FragmentManager manager = activity.getSupportFragmentManager();
        @SuppressLint("RestrictedApi") List<Fragment> fragments = manager.getFragments();
        int size = fragments.size();
        BaseFragment fragment = null;
        if (size>0){
            int position =size-1;
            fragment = (BaseFragment) fragments.get(position);
        }
        return fragment;
    }

}
