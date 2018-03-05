package com.jason_sunyf.core.util.pinyin;


import android.text.TextUtils;

/**
 * 汉字转拼音
 * Created by 江沨 on 2016/12/3.
 */
public class PinYin {
    public PinYin() {
    }

    /**
     * LWH 2016-12-3
     *
     * @param value hanzi
     * @return pinyin
     */
    public static String toPinYin(String value) {
        String pinYin = "";
        if (TextUtils.isEmpty(value)) {
            return pinYin;
        }
        char[] chars = value.toCharArray();
        for (char cha : chars) {
            pinYin += toPinyinFirst(cha);
        }
        return pinYin;
    }

    private static String toPinyinFirst(char cha) {
        String value = toPinyin(cha);
        value = value.substring(0, 1);
        return value;
    }
    /**
     * LWH 2017-1-20
     *
     * @param value 字符串
     * @return 是否全部是汉字
     */
    public static boolean isChinese(String value) {
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        char[] chars = value.toCharArray();
        for (char cha : chars) {
            if (!isChinese(cha)) {
                return false;
            }
        }
        return true;
    }

    /**
     * return pinyin if c is chinese in uppercase, String.valueOf(c) otherwise.
     */
    private static String toPinyin(char c) {
        if (isChinese(c)) {
            if (c == PinYinData.CHAR_12295) {
                return PinYinData.PINYIN_12295;
            } else {
                return PinYinData.PINYIN_TABLE[getPinyinCode(c)];
            }
        } else {
            return String.valueOf(c);
        }
    }

    /**
     * return whether c is chinese
     */
    private static boolean isChinese(char c) {
        return (PinYinData.MIN_VALUE <= c && c <= PinYinData.MAX_VALUE
                && getPinyinCode(c) > 0)
                || PinYinData.CHAR_12295 == c;
    }

    private static int getPinyinCode(char c) {
        int offset = c - PinYinData.MIN_VALUE;
        if (0 <= offset && offset < PinYinData.PINYIN_CODE_1_OFFSET) {
            return decodeIndex(PinYinCode1.PINYIN_CODE_PADDING, PinYinCode1.PINYIN_CODE, offset);
        } else if (PinYinData.PINYIN_CODE_1_OFFSET <= offset
                && offset < PinYinData.PINYIN_CODE_2_OFFSET) {
            return decodeIndex(PinYinCode2.PINYIN_CODE_PADDING, PinYinCode2.PINYIN_CODE,
                    offset - PinYinData.PINYIN_CODE_1_OFFSET);
        } else {
            return decodeIndex(PinYinCode3.PINYIN_CODE_PADDING, PinYinCode3.PINYIN_CODE,
                    offset - PinYinData.PINYIN_CODE_2_OFFSET);
        }
    }

    private static short decodeIndex(byte[] paddings, byte[] indexes, int offset) {
        //CHECKSTYLE:OFF
        int index1 = offset / 8;
        int index2 = offset % 8;
        short realIndex;
        realIndex = (short) (indexes[offset] & 0xff);
        //CHECKSTYLE:ON
        if ((paddings[index1] & PinYinData.BIT_MASKS[index2]) != 0) {
            realIndex = (short) (realIndex | PinYinData.PADDING_MASK);
        }
        return realIndex;
    }
}
