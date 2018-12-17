package com.baise.school.ui.main.video;


import com.baise.baselibs.mvp.IModel;
import com.baise.baselibs.mvp.IView;
import com.baise.school.data.entity.MsgBean;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author 小强
 * @time 2018/6/12 22:57
 * @desc 契约类
 */
public interface NewsContract {


    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        /**
         * 显示发送显示回来的信息
         * @param entity
         */
        void ShowNewsData(MsgBean entity);

    }

    interface Model extends IModel {


        /**
         * 请求数据
         * @param url 请求的地址
         * @param map 请求的参数
         * @return
         */
        Observable<MsgBean> GetNewsData(String url, Map<String, String> map);
    }

}
