# ZADSdk
[![](https://jitpack.io/v/ZADmeng/ZADSdk.svg)](https://jitpack.io/#ZADmeng/ZADSdk)
# 引用
```implementation ('com.github.ZADmeng:ZADSdk:v0.5.0'){
        exclude(group: 'com.squareup.okhttp3', module: 'okhttp')
        exclude(group: 'com.google.android', module: 'design')
        exclude(group: 'com.google.android', module: 'recyclerview-v7')
        exclude(group: 'com.google.code.gson', module: 'gson')
        exclude(group: 'com.squareup.okhttp3', module: 'okhttp')
        exclude(group: 'com.github.bumptech.glide', module: 'glide')
    }
```
# 初始化：在你的工程的application中
```
ZADSdk.init(getApplicationContext(),appId,secretKey);
```
开平广告
```
  new ZADSplash(this, view, "posId", new ZADSplashListener() {
            @Override
            public void onNoAD(AdError error) {
              
            }

            @Override
            public void onADDismissed() {
               
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
    
  new ZADSplash(this, view,view(自定义跳过按钮) "posId", new ZADSplashListener() {
            @Override
            public void onNoAD(AdError error) {
              
            }

            @Override
            public void onADDismissed() {
               
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
        
```
banner广告
ZADBanner
``` 
  ZADBanner zadBanner = new ZADBanner(this, "posId");
        zadBanner.setZADListener(new ZADBannerListener() {
            @Override
            public void onNoAD(AdError error) {

            }

            @Override
            public void onADExposure() {

            }

            @Override
            public void onADClicked() {

            }
        });
        bannerContainer.addView(zadBanner);
        zadBanner.loadAD();
```
插屏广告ZADInterstitial
```
 private void initIt() {
        zadInterstitial = new ZADInterstitial(this, InterteristalPosID);

    }

    private void showAD() {
        zadInterstitial.setZADListener(new ZADInterstitialListener() {
            @Override
            public void onNoAD(AdError error) {

            }

            @Override
            public void onADReceive() {
                zadInterstitial.show();
            }

            @Override
            public void onADOpened() {

            }

            @Override
            public void onADExposure() {

            }

            @Override
            public void onADClicked() {

            }

            @Override
            public void onADClosed() {

            }

            @Override
            public void onADLeftApplication() {

            }
        });
        zadInterstitial.loadAD();
    }

    private void showAsPopup() {
        zadInterstitial.setZADListener(new ZADInterstitialListener() {
            @Override
            public void onNoAD(AdError error) {

            }

            @Override
            public void onADReceive() {
                zadInterstitial.showAsPopupWindow();
            }

            @Override
            public void onADOpened() {

            }

            @Override
            public void onADExposure() {

            }

            @Override
            public void onADClicked() {

            }

            @Override
            public void onADClosed() {

            }

            @Override
            public void onADLeftApplication() {

            }
        });
        zadInterstitial.loadAD();

    }

    private void closeAsPopup() {
        if (zadInterstitial != null) {
            zadInterstitial.closePopupWindow();
        }
    }
    
```
 
