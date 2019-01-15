package com.baise.school.ui.main.mine;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baise.baselibs.Bean.MessageEvent;
import com.baise.baselibs.app.AppConstants;
import com.baise.baselibs.base.BaseFragment;
import com.baise.baselibs.rx.RxBus;
import com.baise.baselibs.utils.SpUtil;
import com.baise.baselibs.utils.ToastUtils;
import com.baise.school.R;
import com.baise.school.constants.EventBusTag;
import com.mylhyl.circledialog.CircleDialog;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author 小强
 * @time 2018/6/12 22:57
 * @desc 我的
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {

    //录音语言
    @BindView(R.id.tv_select_audio) TextView mTvSelectAudio;

    //朗读语言
    @BindView(R.id.tv_select_reading) TextView mTvSelectReading;

    @BindView(R.id.tv_clean_news) TextView mTvCleanNews;
    @BindView(R.id.rl_select_reading) RelativeLayout mRlSelectReading;

    @BindView(R.id.cb_speech) CheckBox mCbSpeech;
    private String mTitle;

    public static MineFragment getInstance(String title) {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }



    @Override
    protected boolean useEventBus() {
        return false;
    }




    /**
     * 请求网络
     */
    @Override
    public void onLazyLoad() {

        //获取朗读设置
        boolean reading = SpUtil.getInstance().getBoolean(AppConstants.READING);
        if (reading) {
            mCbSpeech.setChecked(false);
        }else {
            mCbSpeech.setChecked(true);
        }

    }

    /**
     * 显示错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */
    @Override
    public void showError(String msg, int code) {
        ToastUtils.showShort(msg);
    }

    /**
     * 显示网络错误
     *
     * @param msg  错误信息
     * @param code 错误code
     */
    @Override
    public void showNetworkError(String msg, int code) {
        ToastUtils.showShort(msg);
    }


    @OnClick({R.id.tv_clean_news, R.id.tv_select_audio, R.id.rl_select_audio, R.id.tv_select_reading, R.id.rl_select_reading, R.id.cb_speech})
    public void onClick(View view) {
        switch (view.getId()) {

            //清空聊天记录
            case R.id.tv_clean_news:
                cleanNewsMethod();
                break;

            //录音语言
            case R.id.rl_select_audio:
            case R.id.tv_select_audio:

                selectAudio();
                break;

            //朗读语言
            case R.id.rl_select_reading:
            case R.id.tv_select_reading:
                selectReading();
                break;

            case R.id.cb_speech:

                //获取朗读设置
                boolean reading = SpUtil.getInstance().getBoolean(AppConstants.READING);
                if (reading) {
                  SpUtil.getInstance().putBoolean(AppConstants.READING,false);
                }else {
                    SpUtil.getInstance().putBoolean(AppConstants.READING,true);
                }


                break;
        }
    }

    //朗读语言
    private void selectReading() {
        final String[] items = {"女粤语", "女普通话", "女台湾话", "女四川话", "男普通话", "男河南话"};

        new CircleDialog.Builder().setWidth(0.6f).setTitle("选择朗读语言").
                configDialog(params -> params.gravity = Gravity.CENTER).
                setItems(items, (parent, view, position, id) -> {
                    String name = items[position];
                    mTvSelectReading.setText("朗读语言：" + name);
                    switch (position) {
                        case 0:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_READ, AppConstants.XIAO_MEI);

                            break;
                        case 1:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_READ, AppConstants.XIAO_YAN);
                            break;
                        case 2:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_READ, AppConstants.XIAO_LIN);
                            break;
                        case 3:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_READ, AppConstants.XIAO_RONG);
                            break;
                        case 4:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_READ, AppConstants.XIAO_YU);
                            break;
                        case 5:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_READ, AppConstants.XIAO_KUN);
                            break;
                    }

                    return true;
                }).show(getFragmentManager());
    }


    //录音语言
    private void selectAudio() {
        final String[] items = {"粤语", "英语", "普通话", "河南话"};
        new CircleDialog.Builder().setTitle("选择录音语言").
                setWidth(0.6f).
                configDialog(params -> params.gravity = Gravity.CENTER).
                setItems(items, (parent, view1, position, id) -> {
                    String name = items[position];
                    mTvSelectAudio.setText("录音语言：" + name);
                    switch (position) {
                        case 0:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_RECORD, AppConstants.CANTONESE);
                            break;
                        case 1:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_RECORD, AppConstants.EN_US);
                            break;
                        case 2:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_RECORD, AppConstants.MANDARIN);
                            break;
                        case 3:
                            SpUtil.getInstance().putString(AppConstants.XF_SET_VOICE_RECORD, AppConstants.HENANESE);
                            break;
                    }

                    return true;
                }).show(getFragmentManager());
        return;
    }


    //清空聊天记录
    private void cleanNewsMethod() {
        new CircleDialog.Builder().setTitle("聊天记录").
                setText("确认清空聊天记录吗?").
                setWidth(0.6f).
                setNegative("取消", null).
                configNegative(params -> params.textColor = getResources().getColor(R.color.item_text_color)).
                setPositive("确认", v -> cleanNews()).
                configPositive(params -> params.textColor = getResources().getColor(R.color.item_text_confirm)).
                setCanceledOnTouchOutside(false).
                setCancelable(false).show(getFragmentManager());
    }


    //清空聊天记录
    private void cleanNews() {

        RxBus.getDefault().post(new MessageEvent(EventBusTag.CLEAN_NEWS));

    }

}
