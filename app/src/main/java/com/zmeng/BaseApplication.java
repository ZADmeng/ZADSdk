package com.zmeng;

import android.app.Application;

import com.zad.sdk.main.ZADSdk;

/**
 * 作者：王东一
 * 创建时间：2018/9/19.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZADSdk.init(getApplicationContext(),"1111","");
    }
}
