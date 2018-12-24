package com.baise.school.ui.main.activity;

import android.content.Intent;
import android.os.Handler;

import com.baise.baselibs.base.BaseActivity;
import com.baise.school.R;
import com.baise.school.ui.main.MainActivity;


/**
 * @author 小强
 * @time 2018/12/4  18:06
 * @desc 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {

    /**
     * 获取布局 Id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.welcome;
    }

    /**
     * 请求网络
     */
    @Override
    protected void networkRequest() {
        new Handler().postDelayed(new Runnable(){

            public void run() {
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, MainActivity.class);
                WelcomeActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                WelcomeActivity.this.finish();

            }

        }, 2000);
    }


    /**
     * 是否可以使用沉浸式
     *
     * @return ture-->使用 false-->不使用
     */
    @Override
    protected boolean isImmersionBarEnabled() {
        return false;
    }
}
