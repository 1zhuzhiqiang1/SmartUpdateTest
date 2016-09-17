package com.zzq.smartupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chinasoft.utils.ApkUtils;
import com.chinasoft.utils.L;
import com.chinasoft.utils.PatchUtils;


public class MainActivity extends AppCompatActivity {

    private Context context = null;

    private Button btn_startQR = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        initView();

    }

    private void initView() {
        btn_startQR = (Button) findViewById(R.id.btn_startQR);

        btn_startQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BarCodeTestActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkUpdate();
    }

    private void checkUpdate() {
        PackageInfo packageInfo = ApkUtils.getInstalledApkPackageInfo(context, Constants.TEST_PACKAGENAME);
        if (packageInfo != null && packageInfo.versionCode == 2) {
            String oldApkPath = ApkUtils.getSourceApkPath(context, Constants.TEST_PACKAGENAME);
            L.e("旧apk的安装路径为:" + oldApkPath);
            int patch = PatchUtils.patch(oldApkPath, Constants.NEW_APK_PATH, Constants.PATCH_PATH);
            L.e("合成的结果为：" + patch);
            if (patch == 0) {
                ApkUtils.installApk(context, Constants.NEW_APK_PATH);
            } else {
                showToast("合成失败");
            }
        }
    }

    private void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
