package com.zmeng.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.zad.sdk.model.AdError;
import com.zad.sdk.splash.ZADSplash;
import com.zad.sdk.splash.ZADSplashListener;


/**
 * 作者：王东一
 * 创建时间：2018/9/21.
 */
public class LoadingActivity extends AppCompatActivity {
    private LinearLayout main;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 2001:
                    init();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initView();
    }

    private void initView() {
        main = (LinearLayout) findViewById(R.id.main);
        handler.sendEmptyMessage(2001);
    }

    private void init() {

        new ZADSplash(this, main, "zm_ad_1_1000", new ZADSplashListener() {
            @Override
            public void onNoAD(AdError error) {
                Log.e("错误" + error.getErrorCode(), error.getErrorMsg());
//                main.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        handler.sendEmptyMessage(2001);
//                    }
//                });
//                if(error.getErrorCode()==2001){
//                    Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
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
