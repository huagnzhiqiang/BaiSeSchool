package com.baise.baselibs.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.baise.baselibs.Bean.MessageEvent;
import com.baise.baselibs.R;
import com.baise.baselibs.app.BaseApplication;
import com.baise.baselibs.mvp.BasePresenter;
import com.baise.baselibs.mvp.IView;
import com.baise.baselibs.view.MultipleStatusView;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.RefWatcher;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 小强
 * @time 2018/6/9 17:12
 * @desc fragment 基类
 */
public abstract class BaseFragment<T extends BasePresenter> extends BaseLazyFragment implements IView {

    /**
     * 将代理类通用行为抽出来
     */
    protected T mPresenter;

    private Unbinder unBinder;

    protected BaseActivity mActivity;
    protected MultipleStatusView mLayoutStatusView;

    protected ImmersionBar mImmersionBar;//沉浸式状态栏和沉浸式


    /**
     * 缓存Fragment view
     */
    private View mRootView;//根布局
    private ViewGroup mTitleView;//title布局
    private TextView mToolbarTitle;//中间的title

    private TextView mToolbarRightTitle;//右边的title
    private ImageView mToolbarRigthImg;//右边的图片

    private ViewGroup mFlContentRoot;//子布局

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRootView == null) {

            mRootView = inflater.inflate(R.layout.layout_base_root, null);

            //初始化公用的布局
            initBaseView();

        }

        unBinder = ButterKnife.bind(this, mRootView);


        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        if (useEventBus()) {
            EventBus.getDefault().register(this);//注册eventBus
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            getBundle(arguments);
        }

        initView(mRootView);
        initData();
        initListener();
    }

    //初始化公用的布局
    private void initBaseView() {
        //头部
        mTitleView = (ViewGroup) mRootView.findViewById(R.id.title_view);
        mToolbarTitle = (TextView) mTitleView.findViewById(R.id.toolbar_title);
        mToolbarRightTitle = (TextView) mTitleView.findViewById(R.id.toolbar_right_tv);
        mToolbarRigthImg = (ImageView) mTitleView.findViewById(R.id.toolbar_right_img);

        mFlContentRoot = (ViewGroup) mRootView.findViewById(R.id.fl_content_root);

        mFlContentRoot.removeAllViews();
        mActivity.getLayoutInflater().inflate(getLayoutId(), mFlContentRoot, true);

        //无网络/请求出现了问题布局
        mLayoutStatusView = ButterKnife.findById(mRootView, R.id.multipleStatusView);
        if (mLayoutStatusView != null) {
            mLayoutStatusView.setOnRetryClickListener(layoutStatusViewOnclick);
        }
    }


    /**
     * 获取 Bundle 数据
     */
    protected void getBundle(Bundle arguments) {
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) this.getActivity();
        }
    }


    /**
     * 初始化沉浸式状态栏和沉浸式
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.fitsSystemWindows(true);
        mImmersionBar.statusBarColor(R.color.colorAccent);
        mImmersionBar.navigationBarWithKitkatEnable(false);
        mImmersionBar.init();
    }

    /**
     * 是否可以使用沉浸式
     *
     * @return ture-->使用 false-->不使用
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }


    /**==================初始化Toolbar开始=====================*/

    /**
     * 判断是否显示标题
     *
     * @param isShow true:显示  false:不显示
     */
    public void showTitleView(boolean isShow) {
        mTitleView.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }


    /**
     * 设置标题
     *
     * @param text 标题
     */
    public void setToolbarTitle(CharSequence text) {
        mToolbarTitle.setText(text);
    }

    /**
     * 设置标题
     *
     * @param text  标题
     * @param color 颜色值
     */
    public void setToolbarTitle(CharSequence text, @ColorInt int color) {
        mToolbarTitle.setText(text);

        if (color != 0) {
            mToolbarTitle.setTextColor(color);
        } else {
            mToolbarTitle.setTextColor(0x453d4d);
        }
    }


    /**
     * 设置右边的标题
     *
     * @param title 标题
     * @param color 颜色值
     */
    protected void setToolRightTitle(String title, @ColorInt int color) {
        mToolbarRigthImg.setVisibility(View.GONE);
        if (mToolbarRightTitle != null) {
            mToolbarRightTitle.setText(title);
        }
        if (color != 0) {
            mToolbarRightTitle.setTextColor(color);
        } else {
            mToolbarRightTitle.setTextColor(0xeb6ea5);
        }

    }

    /**
     * 设置右边的标题
     *
     * @param title 标题
     */
    protected void setToolRightTitle(String title) {
        mToolbarRigthImg.setVisibility(View.GONE);
        if (mToolbarRightTitle != null) {
            mToolbarRightTitle.setText(title);
            mToolbarRightTitle.setTextColor(0xeb6ea5);
        }

    }

    /**
     * 设置右边的图片
     *
     * @param resId 图片文件
     */
    protected void setToolRightImg(@DrawableRes int resId) {
        mToolbarRightTitle.setVisibility(View.GONE);
        mToolbarRigthImg.setImageResource(resId);
    }

    /** ==================初始化Toolbar结束===================== */


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (unBinder != null) {
            unBinder.unbind();
        }

        //销毁沉浸式
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }


        if (useEventBus()) {
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);//注销eventBus
            }
        }

        //销毁检查内存泄露问题插件
        initLeakCanary();
    }

    /** ==================Fragment中使用沉浸式设置属性===================== */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && mImmersionBar != null)
            mImmersionBar.init();
    }


    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    @Override
    public void showLoading() {
        Logger.d("showLoading--->:");
        mActivity.showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        mActivity.hideLoadingDialog();
    }

    /**
     * 显示带消息的进度框
     *
     * @param msg 提示
     */
    protected void showLoading(String msg) {
        mActivity.showLoadingDialog(msg);
    }


    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        mActivity.startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        mActivity.startActivityForResult(cls, null, requestCode);
    }


    /**
     * 覆写finish方法，覆盖默认方法，加入切换动画
     */
    public void finishActivity() {
        mActivity.finishActivity();
    }


    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(getBaseActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getBaseActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 用来检测所有Fragment的内存泄漏
     */
    private void initLeakCanary() {
        RefWatcher refWatcher = BaseApplication.getRefWatcher(getContext());
        refWatcher.watch(this);
    }


    /**
     * 返回一个用于显示界面的布局id
     */
    protected abstract @LayoutRes
    int getLayoutId();

    /**
     * 创建Presenter
     *
     * @return 返回当前的Presenter
     */
    protected abstract T createPresenter();

    /**
     * 初始化View的代码写在这个方法中
     */
    protected void initView(View view) {
    }

    /**
     * 初始化监听器的代码写在这个方法中
     */
    protected void initListener() {
    }

    /**
     * 初始数据的代码写在这个方法中，用于从服务器获取数据
     */
    protected void initData() {
    }

    /**
     * 是否使用eventBus
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 接受EventBus 广播
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {
    }


    /**
     * 错误信息页面点击事件(无网络/获取数据出错...)
     **/
    private View.OnClickListener layoutStatusViewOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mActivity.showLoadingDialog();
            onLazyLoad();

        }
    };


}
