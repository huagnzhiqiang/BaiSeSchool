package com.baise.school.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.baise.school.ui.main.video.MsmFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.baise.baselibs.base.BaseMvpActivity;
import com.baise.school.R;
import com.baise.school.data.entity.TabEntity;
import com.baise.school.data.entity.TestNews;
import com.baise.school.ui.main.home.HomeFragment;
import com.baise.school.ui.main.mine.MineFragment;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author 小强
 * @time 2018/12/4  18:06
 * @desc 主页面
 */

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {


    private HomeFragment mHomeFragment;
    private MsmFragment mVideoFragment;
    private MineFragment mMineFragment;

    // 顶部滑动的标签栏
    private String[] mTitles = {"学校", "趣味问答", "我的"};
    // 未被选中的图标
    private int[] mIconUnSelectIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    // 被选中的图标
    private int[] mIconSelectIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    // 默认为0;
    private int mCurrIndex = 0;


    @BindView(R.id.fl_container) FrameLayout flContainer;
    @BindView(R.id.tab_layout) CommonTabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("onCreate...........");

        if (savedInstanceState != null) {
            Logger.d("onRestore enter...." + mCurrIndex);
            mCurrIndex = savedInstanceState.getInt("currTabIndex");
        }
        tabLayout.setCurrentTab(mCurrIndex);
        switchFragment(mCurrIndex);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void getIntent(Intent intent) {

    }

    @Override
    protected void initView() {
        initTab();
    }

    /**
     * 初始化沉浸式状态栏和沉浸式
     */
    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.fitsSystemWindows(false);
        mImmersionBar.init();
    }



    /**
     * 请求网络
     */
    @Override
    protected void networkRequest() {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public void showData(List<TestNews> testNews) {

    }


    /**
     * 初始化底部菜单
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }
        //为Tab赋值数据
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //切换Fragment
                switchFragment(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });


        //设备红点
        tabLayout.showDot(0);
        tabLayout.showMsg(1, 100);
        tabLayout.showDot(2);

    }

    /**
     * 切换Fragment
     *
     * @param position 下标
     */
    private void switchFragment(int position) {
        // Fragment事务管理器
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        Logger.d("current position tab" + position);
        switch (position) {
            case 0: //首页
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance(mTitles[0]);
                    transaction.add(R.id.fl_container, mHomeFragment, "home");
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 1: //视频
                if (mVideoFragment == null) {
                    mVideoFragment = MsmFragment.getInstance(mTitles[1]);
                    transaction.add(R.id.fl_container, mVideoFragment, "video");
                } else {
                    transaction.show(mVideoFragment);
                }
                break;

            case 2: //更多
                if (mMineFragment == null) {
                    mMineFragment = MineFragment.getInstance(mTitles[2]);
                    transaction.add(R.id.fl_container, mMineFragment, "mine");
                } else {
                    transaction.show(mMineFragment);
                }
                break;
            default:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance(mTitles[0]);
                    transaction.add(R.id.fl_container, mHomeFragment, "home");
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
        }
        mCurrIndex = position;
        tabLayout.setCurrentTab(mCurrIndex);
        transaction.commitAllowingStateLoss();

    }

    /**
     * 隐藏所有的Fragment
     *
     * @param transaction transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (null != mHomeFragment) {
            transaction.hide(mHomeFragment);
        }
        if (null != mVideoFragment) {
            transaction.hide(mVideoFragment);
        }
        if (null != mMineFragment) {
            transaction.hide(mMineFragment);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        Logger.e("onSaveInstanceState crash..." + mCurrIndex);
        if (tabLayout != null) {
            outState.putInt("currTabIndex", mCurrIndex);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
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
