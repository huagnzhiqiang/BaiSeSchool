package com.baise.school.ui.main.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baise.baselibs.base.BaseFragment;
import com.baise.baselibs.utils.GsonUtil;
import com.baise.baselibs.utils.ToastUtils;
import com.baise.school.R;
import com.baise.school.adapter.MsmAdapter;
import com.baise.school.app.App;
import com.baise.school.data.entity.MsgBean;
import com.baise.school.data.entity.NewsEntity;
import com.baise.school.data.entity.RecognizerResultEntity;
import com.baise.school.db.DaoSession;
import com.baise.school.db.NewsEntityDao;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.gyf.barlibrary.ImmersionBar;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.greenrobot.greendao.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author 小强
 * @time 2018/6/12 22:57
 * @desc 我的
 */
public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {


    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.sendText) EditText mSendText;
    @BindView(R.id.tv_send_sms) TextView mTvSendSms;
    @BindView(R.id.iv_send) ImageView mIvSend;
    private String mTitle;
    private MsmAdapter mAdapter;

    private double currentTime = 0, oldTime = 0;

    private NewsEntityDao mMsmEntityDao;
    private Query<NewsEntity> mMsmEntityQuery;

    private String[] defaultNest = {"百色学院地址", "地址", "百色学院", "百色", "学院"};


    public static NewsFragment getInstance(String title) {
        NewsFragment fragment = new NewsFragment();
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
    protected NewsPresenter createPresenter() {
        return new NewsPresenter();
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

        DaoSession daoSession = App.getDaoSession();
        mMsmEntityDao = daoSession.getNewsEntityDao();
        mMsmEntityQuery = mMsmEntityDao.queryBuilder().orderAsc(NewsEntityDao.Properties.Id).build();
        initAdapter();

    }


    //插入数据
    private void insertMsm(int type, String content, String date) {
        NewsEntity msmEntity = new NewsEntity(null, content, date, type);
        mMsmEntityDao.insert(msmEntity);
    }


    /**
     * 查询数据库
     *
     * @return 数据库聊天所有数据
     */
    private List<NewsEntity> queryList() {
        return mMsmEntityQuery.list();
    }

    /**
     * 初始化沉浸式状态栏和沉浸式
     */
    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.fitsSystemWindows(false);
        mImmersionBar.keyboardEnable(true);  //解决软键盘与底部输入框冲突问题
        mImmersionBar.statusBarColor(R.color.colorAccent);
        mImmersionBar.keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);  //单独指定软键盘模式
        mImmersionBar.navigationBarWithKitkatEnable(false);
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

            List<NewsEntity> msgEntities = queryList();
            mAdapter.addData(msgEntities);
            mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
        }
    }


    @OnClick({R.id.tv_send_sms, R.id.iv_send})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_send_sms:

                String msg = mSendText.getText().toString().trim();

                if (!TextUtils.isEmpty(msg)) {
                    NewsEntity entity;
                    if (mAdapter != null) {

                        //发送
                        mSendText.setText("");
                        entity = new NewsEntity().setContent(msg).setTime(getTime()).setType(MsmAdapter.SEND);
                        mAdapter.addData(entity);
                        insertMsm(MsmAdapter.SEND, msg, getTime());
                        mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

                        int length = defaultNest.length;

                        for (int i = 0; i < length; i++) {
                            String news = defaultNest[i];
                            if (msg.equals(news)) {
                                mPresenter.requestData(msg);
                                return;
                            }
                        }
                        senNews(msg);
                    }


                } else {
                    ToastUtils.showShort("快来问我问题吧");
                }

                break;

            case R.id.iv_send:


                onRecognise();


                break;
        }


    }

    public void onRecognise() {
        //1.创建RecognizerDialog对象
        RecognizerDialog mDialog = new RecognizerDialog(getContext(), null);
        //2.设置accent、 language等参数
        mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
        //若要将UI控件用于语义理解，必须添加以下参数设置，设置之后onResult回调返回将是语义理解
        //结果
        // mDialog.setParameter("asr_sch", "1");
        // mDialog.setParameter("nlp_version", "2.0");
        //3.设置回调接口
        mDialog.setListener(mRecognizerDialogListener);
        //4.显示dialog，接收语音输入
        mDialog.show();
    }


    //讯飞语音
    private RecognizerDialogListener mRecognizerDialogListener = new RecognizerDialogListener() {

        /**
         *
         * @param recognizerResult 语音识别结果
         * @param b true表示是标点符号
         */
        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            if (b) {
                return;
            }
            RecognizerResultEntity resultEntity = GsonUtil.fromJson(recognizerResult.getResultString(), RecognizerResultEntity.class);

            List<RecognizerResultEntity.WsBean> ws = resultEntity.getWs();
            int size = ws.size();
            String msg = "";
            for (int i = 0; i < size; i++) {
                List<RecognizerResultEntity.WsBean.CwBean> cw = ws.get(i).getCw();
                for (int j = 0; j < cw.size(); j++) {
                    msg += cw.get(j).getW();
                }
            }
            if (mAdapter != null && !TextUtils.isEmpty(msg)) {

                //发送
                mSendText.setText("");
                NewsEntity entity = new NewsEntity().setContent(msg).setTime(getTime()).setType(MsmAdapter.SEND);
                mAdapter.addData(entity);
                insertMsm(MsmAdapter.SEND, msg, getTime());
                mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

                senNews(msg);

            }
        }

        @Override
        public void onError(SpeechError speechError) {

        }
    };


    /**
     * 请求数据
     *
     * @param msg 请求的消息
     */
    public void senNews(String msg) {

        Map<String, String> map = new HashMap<>();

        String url = "http://www.tuling123.com/openapi/api";
        map.put("key", "e2109786d8d4593345fb3b75e65089c0");
        map.put("info", msg);

        mPresenter.requestData(url, map);

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

    /**
     * 显示发送显示回来的信息
     */
    @Override
    public void ShowNewsData(MsgBean data) {
        if (mAdapter != null) {

            //添加到Adapter
            NewsEntity entity = new NewsEntity().setContent(data.getText()).setTime(getTime()).setType(MsmAdapter.RECEIVER);
            mAdapter.addData(entity);
            mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);

            //添加到数据库
            insertMsm(MsmAdapter.RECEIVER, data.getText(), getTime());

        }
    }


    //        /**
    //         * 隐藏软键盘
    //         * hideSoftInputView
    //         *
    //         * @param
    //         * @return void
    //         * @throws
    //         * @Title: hideSoftInputView
    //         */
    //        public void hideSoftInputView() {
    //            InputMethodManager manager = ((InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE));
    //            if (getActivity().getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
    //                if (getCurrentFocus() != null)
    //                    manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    //            }
    //        }
    //
    //        /**
    //         * 弹出输入法窗口
    //         */
    //        public void showSoftInputView(final EditText et) {
    //            new Handler().postDelayed(new Runnable() {
    //                @Override
    //                public void run() {
    //                    ((InputMethodManager) et.getContext().getSystemService(Service.INPUT_METHOD_SERVICE)).toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    //                }
    //            }, 0);
    //        }
}
