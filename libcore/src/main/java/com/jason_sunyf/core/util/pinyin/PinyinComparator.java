//package com.jason_sunyf.core.util.pinyin;
//
//
//import com.sinotech.tms.main.nbky.entity.SortModel;
//
//import java.util.Comparator;
//
///**
// * 比较器
// * Created by 江沨 on 2016/11/30.
// */
//public class PinyinComparator implements Comparator<SortModel> {
//
//    public int compare(SortModel o1, SortModel o2) {
//        if (o1.sortLetters.equals("@")
//                || o2.sortLetters.equals("#")) {
//            return -1;
//        } else if (o1.sortLetters.equals("#")
//                || o2.sortLetters.equals("@")) {
//            return 1;
//        } else {
//            return o1.sortLetters.compareTo(o2.sortLetters);
//        }
//    }
//
//}
