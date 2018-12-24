package com.baise.school.ui.main.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baise.baselibs.base.BaseFragment;
import com.baise.baselibs.mvp.BasePresenter;
import com.baise.school.R;
import com.baise.school.ui.main.activity.WebViewActivity;
import com.orhanobut.logger.Logger;

import butterknife.BindView;


/**
 * @author 小强
 * @time 2018/6/12 22:57
 * @desc 首页
 */
public class HomeFragment extends BaseFragment{


    @BindView(R.id.webView) WebView mWebView;


    public static HomeFragment getInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    /**
     * 创建Presenter
     *
     * @return 返回当前的Presenter
     */
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected void initData() {
        Logger.d("initData--->:");
        initWebView();
    }

    @Override
    protected boolean useEventBus() {
        return false;
    }


    /**
     * 初始化wevView设置
     */
    private void initWebView() {
        //设置用户代理
        WebSettings settings = mWebView.getSettings();
        settings.setDomStorageEnabled(true);
        settings.supportMultipleWindows();
        settings.setAllowContentAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setLoadsImagesAutomatically(true);
        //设置可以访问文件
        settings.setAllowFileAccess(true);
        //调用JS方法.安卓版本大于17,加上注解 @JavascriptInterface
        settings.setJavaScriptEnabled(true);
        // 启动缓存
        settings.setAppCacheEnabled(true);
        // 设置缓存模式
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

        mWebView.loadUrl("http://www.bsuc.cn/index.htm");//在线模板


        mWebView.setWebViewClient(new WebViewClient() {

            /**
             * 多页面在同一个WebView中打开，就是不新建activity或者调用系统浏览器打开
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) { // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边

                Bundle bundle = new Bundle();
                if(!TextUtils.isEmpty(url)) {
                    Logger.d("getIntent--->:" + url);
                    bundle.putString(WebViewActivity.URL,url);
                    startActivity(WebViewActivity.class, bundle);
                }

                return true;
            }

        });

    }



    /**
     * 请求网络
     */
    @Override
    public void onLazyLoad() {

    }

    /**
     * 显示错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */
    @Override
    public void showError(String msg, int code) {

    }

    /**
     * 显示网络错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */
    @Override
    public void showNetworkError(String msg, int code) {

    }

}
