package com.zzq.smartupdate;

import android.app.Application;

/**
 * Created by ZHUZHIQIANG on 2016/8/2 0002.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    static {
        System.loadLibrary("ApkPatchLibrary");
    }
}
