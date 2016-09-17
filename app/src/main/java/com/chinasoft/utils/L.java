package com.chinasoft.utils;

import android.util.Log;

import com.zzq.smartupdate.Constants;

/**
 * Created by zhuzhiqiang on 2016/8/2 0002.
 */
public class L {
    public static void e(String msg){
        if(Constants.DEBUG){
            Log.e("TAG",msg);
        }
    }
}
