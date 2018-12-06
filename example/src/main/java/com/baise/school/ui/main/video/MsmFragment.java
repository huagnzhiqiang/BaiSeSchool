package com.baise.school.ui.main.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baise.baselibs.base.BaseFragment;
import com.baise.baselibs.utils.ToastUtils;
import com.baise.school.R;
import com.baise.school.adapter.MsmAdapter;
import com.baise.school.data.entity.MsmEntity;
import com.baise.school.data.entity.MsnBean;
import com.baise.school.data.repository.RetrofitUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    @BindView(R.id.tv_send_sms) TextView mTvSendSms;
    @BindView(R.id.iv_send) ImageView mIvSend;
    private String mTitle;
    private MsmAdapter mAdapter;

    private double currentTime = 0, oldTime = 0;


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
        mSendText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    mTvSendSms.setVisibility(View.VISIBLE);
                    mIvSend.setVisibility(View.GONE);
                } else {
                    mTvSendSms.setVisibility(View.GONE);
                    mIvSend.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    @Override
    protected void initData() {

        initAdapter();

    }


    /**
     * 初始化沉浸式状态栏和沉浸式
     */
    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.fitsSystemWindows(false);
        mImmersionBar.keyboardEnable(true);  //解决软键盘与底部输入框冲突问题
        mImmersionBar.init();
    }


    /** ==================初始化适配器===================== */
    private void initAdapter() {
        mAdapter = new MsmAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        mAdapter.setLoadMoreView(new SimpleLoadMoreView());

        if (mAdapter != null) {
            MsmEntity entity = new MsmEntity().setContent("欢迎来到百色学院").setTime(getTime()).setType(MsmAdapter.RECEIVER);
            mAdapter.addData(entity);
        }
    }


    @OnClick(R.id.tv_send_sms)
    public void onClick() {

        String msg = mSendText.getText().toString().trim();
        if (!TextUtils.isEmpty(msg)) {
            MsmEntity entity;
            if (mAdapter != null) {
                mSendText.setText("");
                entity = new MsmEntity().setContent(msg).setTime(getTime()).setType(MsmAdapter.SEND);
                mAdapter.addData(entity);
                mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

                if (msg.equals("百色学院地址")) {
                    String s = "广西百色中山二路21号。";

                    entity = new MsmEntity().setContent(s).setTime(getTime()).setType(MsmAdapter.RECEIVER);
                    mAdapter.addData(entity);
                    mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

                } else if (msg.equals("百色学院")) {
                    String s = "东合校区：广西百色中山二路21号,澄碧校区：324国道百色学院澄碧校区(东南门)附近";

                    entity = new MsmEntity().setContent(s).setTime(getTime()).setType(MsmAdapter.RECEIVER);
                    mAdapter.addData(entity);
                    mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

                } else if (msg.equals("百色学院简介")) {
                    String s = "百色学院是2006年教育部批准成立的实行“区市共建、以市为主”办学体制的普通本科高校。77年来，学校坚持在“老、少、边、山、穷、库”地区办学，凝练了“团结合作、艰苦奋斗、克难攻坚、磨砺成才”的“石磨精神”，走出一条艰苦创业的发展之路，为边疆民族地区的经济发展、社会进步和国防巩固作出巨大贡献。";
                    entity = new MsmEntity().setContent(s).setTime(getTime()).setType(MsmAdapter.RECEIVER);
                    mAdapter.addData(entity);
                    mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

                } else {
                    senSms(msg);
                }

            }


        } else {
            ToastUtils.showShort("快来问我问题吧");
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
                            MsmEntity entity = new MsmEntity().setContent(s.getText()).setTime(getTime()).setType(MsmAdapter.RECEIVER);
                            mAdapter.addData(entity);
                            mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
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


    private String getTime() {

        currentTime = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date();
        String str = format.format(curDate);
        if (currentTime - oldTime >= 50000) {
            oldTime = currentTime;
            return str;
        } else {
            return "";
        }

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



//    /**
//     * 隐藏软键盘
//     * hideSoftInputView
//     *
//     * @param
//     * @return void
//     * @throws
//     * @Title: hideSoftInputView
//     */
//    public void hideSoftInputView() {
//        InputMethodManager manager = ((InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE));
//        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
//            if (getCurrentFocus() != null)
//                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//        }
//    }
//
//    /**
//     * 弹出输入法窗口
//     */
//    public void showSoftInputView(final EditText et) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ((InputMethodManager) et.getContext().getSystemService(Service.INPUT_METHOD_SERVICE)).toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//            }
//        }, 0);
//    }
}
