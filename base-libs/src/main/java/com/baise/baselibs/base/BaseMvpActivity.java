package com.baise.baselibs.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baise.baselibs.mvp.BasePresenter;
import com.baise.baselibs.mvp.IView;
import com.orhanobut.logger.Logger;

/**
 * @author 小强
 * @time 2018/6/9 17:12
 * @desc 基类 BaseMvpActivity
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements IView {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();

        Logger.d("onCreate--->:" + "基类 BaseMvpActivity");
        if (mPresenter != null) {
            Logger.d("onCreate--->:" + "基类 attachView");
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);

    }


    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
    }


    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
