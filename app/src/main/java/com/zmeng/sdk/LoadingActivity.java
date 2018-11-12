package com.zmeng.sdk;

/**
 * 作者：王东一
 * 创建时间：2018/9/21.
 */
public class LoadingActivity {
//    private LinearLayout main;
//    private Handler handler = new Handler() {
////        @Override
////        public void handleMessage(Message msg) {
////            super.handleMessage(msg);
////            switch (msg.what) {
////                case 2001:
////                    init();
////                    break;
////            }
////        }
////    };

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_loading);
//        initView();
//    }
//
//    private void initView() {
//        main = (LinearLayout) findViewById(R.id.main);
//        if (Build.VERSION.SDK_INT >= 23) {
//            checkAndRequestPermission();
//        } else {
//            handler.sendEmptyMessage(2001);
//        }
//    }
//
//    private void init() {
//
//        new ZADSplash(this, main, "zm_ad_1_1000", new ZADSplashListener() {
//            @Override
//            public void onNoAD(AdError error) {
//                Log.e("错误" + error.getErrorCode(), error.getErrorMsg());
////                main.post(new Runnable() {
////                    @Override
////                    public void run() {
////                        handler.sendEmptyMessage(2001);
////                    }
////                });
////                if(error.getErrorCode()==2001){
////                    Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
////                    startActivity(intent);
////                    finish();
////                }
//            }
//
//            @Override
//            public void onADDismissed() {
//                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//
//            @Override
//            public void onADPresent() {
//
//            }
//
//            @Override
//            public void onADClicked() {
//
//            }
//
//            @Override
//            public void onADExposure() {
//
//            }
//        });
//    }
//
//    @TargetApi(Build.VERSION_CODES.M)
//    private void checkAndRequestPermission() {
//        List<String> lackedPermission = new ArrayList<String>();
//        if (!(checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)) {
//            lackedPermission.add(Manifest.permission.READ_PHONE_STATE);
//        }
//
//        if (!(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
//            lackedPermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//
//        if (!(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
//            lackedPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
//        }
//
//        // 权限都已经有了，那么直接调用SDK
//        if (lackedPermission.size() == 0) {
//            init();
//        } else {
//            // 请求所缺少的权限，在onRequestPermissionsResult中再看是否获得权限，如果获得权限就可以调用SDK，否则不要调用SDK。
//            String[] requestPermissions = new String[lackedPermission.size()];
//            lackedPermission.toArray(requestPermissions);
//            requestPermissions(requestPermissions, 1024);
//        }
//    }
//
//    private boolean hasAllPermissionsGranted(int[] grantResults) {
//        for (int grantResult : grantResults) {
//            if (grantResult == PackageManager.PERMISSION_DENIED) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 1024 && hasAllPermissionsGranted(grantResults)) {
//            init();
//        } else {
//            // 如果用户没有授权，那么应该说明意图，引导用户去设置里面授权。
//            Toast.makeText(this, "应用缺少必要的权限！请点击\"权限\"，打开所需要的权限。", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//            intent.setData(Uri.parse("package:" + getPackageName()));
//            startActivity(intent);
//            finish();
//        }
//    }
}
