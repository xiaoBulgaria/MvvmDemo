package com.gene.mvvmdemo.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/9/27.
 */
public class StringsUtils {

    @NonNull
    private  String mId;

    @Nullable
    private  String mTitle;

    @Nullable
    private  String mDescription;

    private boolean mCompleted;




    public static String capitalize(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }
}
