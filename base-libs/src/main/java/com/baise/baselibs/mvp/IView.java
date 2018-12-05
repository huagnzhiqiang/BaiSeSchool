package com.baise.baselibs.mvp;

/**
 * @author 小强
 * @time 2018/6/9 17:12
 * @desc
 */
public interface IView {


    //显示loading
    void showLoading();

    //隐藏loading
    void hideLoading();

    /**
     * 显示错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */

    void showError(String msg, int code);

    /**
     * 显示网络错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */
    void showNetworkError(String msg, int code);
}
