package com.baise.school.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baise.baselibs.base.BaseActivity;
import com.baise.baselibs.utils.ToastUtils;
import com.baise.baselibs.view.MultipleStatusView;
import com.baise.school.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

@SuppressLint("SetJavaScriptEnabled")

/**
 * @author 小强
 * @time 2018/12/4  18:06
 * @desc WebView页面
 */ public class WebViewActivity extends BaseActivity {


    public static final String URL = "url";

    @BindView(R.id.web) WebView mWeb;
    @BindView(R.id.multipleStatusView) MultipleStatusView mMultipleStatusView;
    private String mUrl;


    /**
     * 获取布局 Id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }


    /**
     * 获取 Intent 数据
     */
    @Override
    protected void getIntent(Intent intent) {
        mUrl = intent.getStringExtra(URL);
    }


    /**
     * 初始数据的代码写在这个方法中，用于从服务器获取数据
     */
    @Override
    protected void initData() {

        setToolbarTitle("百色学院");


        setWebView(mUrl);
    }

    /**
     * 请求网络
     */
    @Override
    protected void networkRequest() {

    }


    private void setWebView(final String loadUrl) {

        WebSettings mWebSettings = mWeb.getSettings();

        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.supportMultipleWindows();
        mWebSettings.setAllowContentAccess(true);
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mWebSettings.setSavePassword(true);
        mWebSettings.setSaveFormData(true);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);


        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("utf-8");
        mWebSettings.setLoadsImagesAutomatically(true);
        //设置可以访问文件
        mWebSettings.setAllowFileAccess(true);
        //调用JS方法.安卓版本大于17,加上注解 @JavascriptInterface
        mWebSettings.setJavaScriptEnabled(true);
        // 启动缓存
        mWebSettings.setAppCacheEnabled(true);
        // 设置缓存模式
        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWeb.setWebChromeClient(webChromeClient);


        mWebSettings.setBlockNetworkImage(false); // 解决图片不显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWeb.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        mWeb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mMultipleStatusView.showLoading();

                Logger.d("onPageStarted--->:");
            }

            /**
             * 多页面在同一个WebView中打开，就是不新建activity或者调用系统浏览器打开
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) { // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边

                if (!TextUtils.isEmpty(url)) {
                    if (!url.contains(".htm#PhotoSwipe")) {
                        Bundle bundle = new Bundle();
                        Logger.d("getIntent--->:" + url);
                        bundle.putString(WebViewActivity.URL, url);
                        startActivity(WebViewActivity.class, bundle);
                        Logger.d("shouldOverrideUrlLoading--->:" + "不是图片-->" + url);
                    } else {
                        ToastUtils.showShort("图片");
                        Logger.d("shouldOverrideUrlLoading--->:" + "图片-->" + url);

                    }

                }

                return false;
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                Logger.d("onPageFinished--->:" + url.toString());
                mMultipleStatusView.showContent();
            }
        });


        mWeb.loadUrl(loadUrl);

    }


    WebChromeClient webChromeClient = new WebChromeClient() {

        //=========HTML5定位==========================================================
        //需要先加入权限
        //<uses-permission android:name="android.permission.INTERNET"/>
        //<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
        //<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
            callback.invoke(origin, true, false);//注意个函数，第二个参数就是是否同意定位权限，第三个是是否希望内核记住
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
        //=========HTML5定位==========================================================

        //=========多窗口的问题==========================================================
        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(view);
            resultMsg.sendToTarget();
            return true;
        }
        //=========多窗口的问题==========================================================
    };

    @Override
    protected void onDestroy() {
        mWeb.destroy();
        super.onDestroy();
        if (mWeb != null) {
            mWeb.clearHistory();
            ((ViewGroup) mWeb.getParent()).removeView(mWeb);
            mWeb.loadUrl("about:blank");
            mWeb.stopLoading();
            mWeb.setWebChromeClient(null);
            mWeb.setWebViewClient(null);
            mWeb.destroy();
            mWeb = null;
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        mWeb.stopLoading();
    }

    @Override
    public void onPause() {
        super.onPause();
        mWeb.onPause();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mWeb.getSettings().setMediaPlaybackRequiresUserGesture(true);
            mWeb.onPause(); // 暂停网页中正在播放的视频
        }
        mWeb.reload();
        mWeb.pauseTimers(); //小心这个！！！暂停整个 WebView 所有布局、解析、JS。
    }

    @Override
    public void onResume() {
        super.onResume();
        mWeb.onResume();
        mWeb.resumeTimers();
    }

}
