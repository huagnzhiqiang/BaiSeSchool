package com.baise.baselibs.net;


import android.accounts.NetworkErrorException;

import com.baise.baselibs.mvp.IView;
import com.baise.baselibs.net.exception.ServerException;
import com.orhanobut.logger.Logger;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author 小强
 * @time 2018/6/12 10:51
 * @desc Observer基类
 */
public abstract class BaseObserver<T> implements Observer<BaseHttpResult<T>> {

    private IView mView;

    private boolean isShowDialog = true;

    public BaseObserver(IView mView) {
        this.mView = mView;
    }

    public BaseObserver(IView mView, boolean isShowDialog) {
        this.mView = mView;
        this.isShowDialog = isShowDialog;
    }

    @Override
    public void onSubscribe(Disposable d) {
        showLoadingDialog();
    }

    @Override
    public void onNext(BaseHttpResult<T> result) {
        hideLoadingDialog();
        if (result.isOk()) {
            onSuccess(result);
            Logger.e("请求成功返回数据--->:" + result.getData().toString());
        } else {
            //TODO API异常处理
            onFailure(result.getMessage(), result.getCode(),false);
            Logger.d("onNext--->:" );
        }
    }

    @Override
    public void onError(Throwable e) {

        hideLoadingDialog();
        ServerException serverException = ServerException.handleException(e);
        if (e instanceof ConnectException
                || e instanceof TimeoutException
                || e instanceof HttpException
                || e instanceof NetworkErrorException
                || e instanceof UnknownHostException) {

            onFailure(serverException.getMessage(),serverException.getCode(), true);
        } else {

            onFailure(serverException.getMessage(), serverException.getCode(),false);
        }
    }

    /**
     * Notifies the Observer that the {@link Observable} has finished sending push-based notifications.
     * <p>
     * The {@link Observable} will not call this method if it calls {@link #onError}.
     * * 请求成功了才会调用 onComplete
     * onError 时不会调用
     */
    @Override
    public void onComplete() {
        hideLoadingDialog();
    }


    /**
     * 请求成功返回
     *
     * @param result 服务器返回数据
     */
    public abstract void onSuccess(BaseHttpResult<T> result);

    /**
     * 请求失败返回
     *
     * @param errMsg     失败信息
     * @param errCode    失败code
     * @param isNetError 是否是网络异常
     */
    public abstract void onFailure(String errMsg, int errCode, boolean isNetError);


    /**
     * 显示 LoadingDialog
     */
    private void showLoadingDialog() {
        if (isShowDialog && mView != null) {
            mView.showLoading();
        }
    }

    /**
     * 隐藏 Loading
     */
    private void hideLoadingDialog() {
        if (mView != null) {
            mView.hideLoading();
        }
    }

}
