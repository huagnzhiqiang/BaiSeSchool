package com.baise.school.ui.main.video;


import com.baise.baselibs.mvp.BaseModel;
import com.baise.school.data.entity.MsgBean;
import com.baise.school.data.repository.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author 小强
 * @time 2018/6/13 15:35
 * @desc
 */
public class NewsModel extends BaseModel implements NewsContract.Model {


    /**
     * 请求数据
     *
     * @param url 请求的地址
     * @param map 请求的参数
     */
    @Override
    public Observable<MsgBean> GetNewsData(String url, Map<String, String> map) {
        return RetrofitUtils.getHttpService().requestNewsData(url, map);
    }
}
