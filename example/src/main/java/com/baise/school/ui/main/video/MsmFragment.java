package com.baise.school.ui.main.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.EditText;

import com.baise.baselibs.base.BaseFragment;
import com.baise.school.R;
import com.baise.school.adapter.MsmAdapter;
import com.baise.school.data.entity.MsmEntity;
import com.baise.school.data.entity.MsnBean;
import com.baise.school.data.repository.RetrofitUtils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 小强
 * @time 2018/6/12 22:57
 * @desc 我的
 */
public class MsmFragment extends BaseFragment<VideoPresenter> {


    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.sendText) EditText mSendText;
    private String mTitle;
    private MsmAdapter mAdapter;

    public static MsmFragment getInstance(String title) {
        MsmFragment fragment = new MsmFragment();
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

        initAdapter();

    }

    /** ==================初始化适配器===================== */
    private void initAdapter() {
        mAdapter = new MsmAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        mAdapter.setLoadMoreView(new SimpleLoadMoreView());
    }


    @OnClick(R.id.iv_send)
    public void onClick() {

        String msg = mSendText.getText().toString().trim();
        if (!TextUtils.isEmpty(msg)) {

            if (mAdapter != null) {
                mSendText.setText("");


                MsmEntity entity = new MsmEntity().setContent(msg).setType(MsmAdapter.SEND);
                mAdapter.addData(entity);
            }
            senSms(msg);
        }
    }


    public void senSms(String msg) {

        Map<String, String> map = new HashMap<>();

        String url = "http://www.tuling123.com/openapi/api";
        map.put("key", "e2109786d8d4593345fb3b75e65089c0");
        map.put("info", msg);

        RetrofitUtils.getHttpService().requestSmsData(url, map).subscribeOn(Schedulers.io()).
                observeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<MsnBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MsnBean s) {


                        if (mAdapter != null) {
                            MsmEntity entity = new MsmEntity().setContent(s.getText()).setType(MsmAdapter.RECEIVER);

                            mAdapter.addData(entity);
                        }
                        Logger.d("onError--->:" + s.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("onError--->:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

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
