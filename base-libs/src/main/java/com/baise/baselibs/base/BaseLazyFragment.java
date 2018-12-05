package com.baise.baselibs.base;

import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * @author 小强
 * @time 2018/10/27  10:03
 * @desc 懒加载 Fragment 基类
 */
public abstract class BaseLazyFragment extends RxFragment {

    /**
     * Fragment的View加载完毕的标记
     */
    protected boolean isViewInitiated;
    /**
     * Fragment对用户可见的标记
     */
    protected boolean isVisibleToUser;
    /**
     * 是否懒加载 (加载过数据)
     */
    protected boolean isAlreadyLoadData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 第一步,改变isViewInitiated标记
     * 当onViewCreated()方法执行时,表明View已经加载完毕,此时改变isViewInitiated标记为true,并调用lazyLoad()方法
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        //只有Fragment onCreateView好了，

        Logger.d("lazyLoad--->:" + "onActivityCreated");
        lazyLoad();
    }

    /**
     * 第二步
     * 此方法会在onCreateView(）之前执行
     * 当viewPager中fragment改变可见状态时也会调用
     * 当fragment 从可见到不见，或者从不可见切换到可见，都会调用此方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            //可见
            this.isVisibleToUser = true;
            lazyLoad();
            Logger.d("lazyLoad--->:" + "可见");
        } else {
            //不可见
            this.isVisibleToUser = false;
            Logger.d("lazyLoad--->:" + "不可见");
            onInVisible();

        }
    }

    /**
     * 第三步:在lazyLoad()方法中进行双重标记判断,通过后即可进行数据加载
     * 第一种方法
     * 调用懒加载，getUserVisibleHint()会返回是否可见状态
     * 这是fragment实现懒加载的关键,只有fragment 可见才会调用onLazyLoad() 加载数据
     */
    private void lazyLoad() {
        if (getUserVisibleHint() && isViewInitiated && !isAlreadyLoadData) {

            Logger.d("lazyLoad--->:" + "第三步加载");
            onLazyLoad();
            isAlreadyLoadData = true;
        } else {
            Logger.d("lazyLoad--->:" + "第三步已经加载过");

        }

    }


    /**
     * 第四步:定义抽象方法fetchData(),具体加载数据的工作,交给子类去完成
     */
    public abstract void onLazyLoad();


    /**
     * 不可见时候 判断是否加载过数据
     */
    private void onInVisible() {
        if (isAlreadyLoadData) {
            InVisibleEvent();
        }
    }


    /**
     * 加载过数据后，fragment变为不可见之后的需要执行的操作
     */
    public void InVisibleEvent() {
        Logger.d("lazyLoad--->:" + "加载过数据");

    }


}