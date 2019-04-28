package com.baise.school.data.api;

import com.baise.school.data.entity.MsgBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @author 小强
 * @date 2018/6/11 23:04
 * @desc 接口管理
 */
public interface ApiService {

    //获取聊天
    @GET
    Observable<MsgBean> requestNewsData(@Url String url, @QueryMap Map<String,String> map);
}
