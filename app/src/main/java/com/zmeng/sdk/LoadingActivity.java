package com.zmeng.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.zmt.ad.model.AdError;
import com.zmt.ad.splash.ZADSplash;
import com.zmt.ad.splash.ZADSplashListener;


/**
 * 作者：王东一
 * 创建时间：2018/9/17.
 */
public class LoadingActivity extends AppCompatActivity {
    private LinearLayout main;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initView();
    }

    private void initView() {
        main = (LinearLayout) findViewById(R.id.main);
        new ZADSplash(this, main, "8863364436303842593", new ZADSplashListener() {
            @Override
            public void onNoAD(AdError error) {
                Log.e("错误", error.getErrorMsg());
            }

            @Override
            public void onADDismissed() {
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onADPresent() {

            }

            @Override
            public void onADClicked() {

            }

            @Override
            public void onADExposure() {

            }
        });
    }
}
