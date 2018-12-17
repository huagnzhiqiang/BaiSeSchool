package com.baise.school.adapter;

import com.baise.school.R;
import com.baise.school.data.entity.NewsEntity;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * @author 小强
 * @time 2018/12/5  14:24
 * @desc 发送短信适配器
 */
public class MsmAdapter extends BaseMultiItemQuickAdapter<NewsEntity, BaseViewHolder> {

    public static final int SEND = 1;
    public static final int RECEIVER = 2;

    public MsmAdapter() {
        super(null);
        addItemType(RECEIVER, R.layout.left);
        addItemType(SEND, R.layout.right);
    }


    @Override
    protected void convert(BaseViewHolder helper, NewsEntity item) {


        switch (helper.getItemViewType()) {

            //发送
            case SEND:
                helper.setText(R.id.tv, item.getContent()).setText(R.id.time, item.getTime());
                break;

            //接收
            case RECEIVER:
                helper.setText(R.id.tv, item.getContent()).setText(R.id.time, item.getTime());

                break;
        }
    }
}
