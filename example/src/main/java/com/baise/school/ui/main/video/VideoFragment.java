package com.baise.school.ui.main.video;

import android.os.Bundle;
import android.widget.TextView;

import com.baise.baselibs.Bean.MessageEvent;
import com.baise.baselibs.base.BaseFragment;
import com.baise.baselibs.rx.RxBus;
import com.baise.school.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

/**
 * @author 小强
 * @time  2018/6/12 22:57
 * @desc 我的
 */
public class VideoFragment extends BaseFragment<VideoPresenter> {

    @BindView(R.id.textView)
    TextView textView;

    private String mTitle;

    public static VideoFragment getInstance(String title) {
        VideoFragment fragment = new VideoFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    protected VideoPresenter createPresenter() {
        return new VideoPresenter();
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.addDispose(RxBus.getDefault().toObservable(MessageEvent.class)
                .subscribe(new Consumer<MessageEvent>() {
                    @Override
                    public void accept(MessageEvent testEvent) throws Exception {
                        if(testEvent!=null){

                            Logger.d("accept--->:" + testEvent.getResult());
                            textView.setText((String)testEvent.getResult());

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
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
