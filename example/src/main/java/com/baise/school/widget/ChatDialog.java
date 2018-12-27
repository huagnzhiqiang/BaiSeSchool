package com.baise.school.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baise.school.R;


/**
 * @author 小强
 * @time 2018/4/17  13:58
 * @desc 下载提示框
 */

public class ChatDialog extends Dialog {

    Callback callback;
    private TextView content;
    private ImageView mIvIcon;


    public ChatDialog(Context context) {
        super(context, R.style.CustomDialog);
        setCustomDialog();
    }

    private void setCustomDialog() {
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.dialog, null);
        content = (TextView) mView.findViewById(R.id.tv_content);
        mIvIcon = (ImageView) mView.findViewById(R.id.iv_icon);
        super.setContentView(mView);
    }


    public ChatDialog setContent(String s) {
        content.setText(s);
        return this;
    }

    /**
     * 设置录音动画
     * @param drawable
     * @return
     */
    public ChatDialog setDrawable( Drawable drawable) {
        mIvIcon.setImageDrawable(drawable);
        return this;
    }

    public interface Callback {
        void callback(int position);
    }

}
