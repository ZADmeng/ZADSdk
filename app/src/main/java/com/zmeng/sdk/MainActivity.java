package com.zmeng.sdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.zad.sdk.model.AdError;
import com.zad.sdk.splash.ZADSplash;
import com.zad.sdk.splash.ZADSplashListener;


public class MainActivity extends AppCompatActivity {

    private LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        main = (LinearLayout) findViewById(R.id.main);
        new ZADSplash(this, main, "aaa", new ZADSplashListener() {
            @Override
            public void onNoAD(AdError error) {
                Log.e("错误"+error.getErrorCode(), error.getErrorMsg());
            }

            @Override
            public void onADDismissed() {
//                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
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
