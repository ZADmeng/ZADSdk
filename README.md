# ZADSdk
[![](https://jitpack.io/v/ZADmeng/ZADSdk.svg)](https://jitpack.io/#ZADmeng/ZADSdk)
# targetSdkVersion>23的可以参考：
### https://github.com/ZADmeng/ZADDemo/tree/master
# 引用
```
implementation ('com.github.ZADmeng:ZADSdk:v0.5.0'){
        exclude(group: 'com.google.code.gson', module: 'gson')
    }
```
# 初始化：在你的工程的application中
```
ZADSdk.init(getApplicationContext(),appId,secretKey);
```
在你的manifest中
```
    <application
        android:name=".BaseApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        tools:ignore="GoogleAppIndexingWarning">
        <!--加入你的key-->
        <meta-data
            android:name="PUSH_APPKEY"
            android:value="1d7512fb70e34df612a1676c" />
        <!--加入你的渠道-->
        <meta-data
            android:name="PUSH_CHANNEL"
            android:value="default_developer" />
            
        <!-- targetSDKVersion >= 24时才需要添加这个provider。provider的authorities属性的值为${applicationId}.fileprovider，请开发者根据自己的${applicationId}来设置这个值-->
        <provider
            android:name="android.support.v4.content.FileProvider"
            android:authorities="${applicationId}.fileprovider"
            android:exported="false"
            android:grantUriPermissions="true">
            <meta-data
                android:name="android.support.FILE_PROVIDER_PATHS"
                android:resource="@xml/zad_file_path" />
        </provider>

        <activity android:name=".LoadingActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".MainActivity" />
    </application>
```
开屏广告
```
 // 如果targetSDKVersion >= 23，那么必须要申请到所需要的权限，再调用SDK，否则SDK不会工作。
 @TargetApi(Build.VERSION_CODES.M)
  private void checkAndRequestPermission() {
    List<String> lackedPermission = new ArrayList<String>();
    if (!(checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)) {
      lackedPermission.add(Manifest.permission.READ_PHONE_STATE);
    }

    if (!(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
      lackedPermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    if (!(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
      lackedPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    // 权限都已经有了，那么直接调用SDK
    if (lackedPermission.size() == 0) {
    //开始开屏广告
    } else {
      // 请求所缺少的权限，在onRequestPermissionsResult中再看是否获得权限，如果获得权限就可以调用SDK，否则不要调用SDK。
      String[] requestPermissions = new String[lackedPermission.size()];
      lackedPermission.toArray(requestPermissions);
      requestPermissions(requestPermissions, 1024);
    }
  }
   private boolean hasAllPermissionsGranted(int[] grantResults) {
    for (int grantResult : grantResults) {
      if (grantResult == PackageManager.PERMISSION_DENIED) {
        return false;
      }
    }
    return true;
  }
   @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 1024 && hasAllPermissionsGranted(grantResults)) {
     //得到权限开始开屏
    } else {
      // 如果用户没有授权，那么应该说明意图，引导用户去设置里面授权。
      Toast.makeText(this, "应用缺少必要的权限！请点击\"权限\"，打开所需要的权限。", Toast.LENGTH_LONG).show();
      Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
      intent.setData(Uri.parse("package:" + getPackageName()));
      startActivity(intent);
      finish();
    }
  }

//开屏广告的方法  
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
 
