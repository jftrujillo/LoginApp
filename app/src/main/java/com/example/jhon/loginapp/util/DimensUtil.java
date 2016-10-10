package com.example.jhon.loginapp.util;

import android.content.Context;

/**
 * Created by jhon on 5/10/16.
 */

public class DimensUtil {

    public static int pxToDp(int sizeInDp, Context context){
        float scale = context.getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (sizeInDp*scale + 0.5f);
        return dpAsPixels;
    }
}
