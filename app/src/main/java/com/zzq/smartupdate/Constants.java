package com.zzq.smartupdate;

import android.os.Environment;

import java.io.File;

/**
 * 常量类
 */
public class Constants {

    public static final boolean DEBUG = true;

    //用于测试的packageName
    public static final String TEST_PACKAGENAME = "com.zzq.smartupdate";

    public static final String PATH = Environment.getExternalStorageDirectory() + File.separator;

    //合成得到的新版apk
    public static final String NEW_APK_PATH = PATH + File.separator + "new.apk";

    //从服务器下载来的差分包
    public static final String PATCH_PATH = PATH + File.separator + "smartUpdateTest.patch";
}