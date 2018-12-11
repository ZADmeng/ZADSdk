package com.zmeng.sdk;

import android.app.Application;

import com.zad.sdk.main.ZADSdk;


/**
 * 作者：王东一
 * 创建时间：2018/9/20.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZADSdk.init(getApplicationContext(),"zm_app_1000","8QEYqLu7bcqFGGoE");
    }
}
