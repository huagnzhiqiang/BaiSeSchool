package com.baise.school.ui.main.video;


import com.baise.baselibs.mvp.BasePresenter;
import com.baise.baselibs.rx.RxSchedulers;
import com.baise.school.data.entity.MsgBean;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author 小强
 * @time  2018/6/12 22:57
 * @desc
 */
public class NewsPresenter extends BasePresenter<NewsContract.Model,NewsContract.View> {
    @Override
    protected NewsContract.Model createModel() {
        return new NewsModel();
    }


    public void requestData(String url, Map<String, String> map){

        getModel().GetNewsData(url,map).compose(RxSchedulers.applySchedulers(getLifecycleProvider())).
                subscribe(new Observer<MsgBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MsgBean msgBean) {
                        getView().ShowNewsData(msgBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public void requestData(String msg){

        String resuleMsg = "";

        if (msg.equals("百色学院地址") || msg.equals("地址")) {
            resuleMsg = "广西百色中山二路21号。";
        } else if (msg.equals("百色学院") || msg.equals("学院")) {
            resuleMsg = "东合校区：广西百色中山二路21号,澄碧校区：324国道百色学院澄碧校区(东南门)附近";

        } else if (msg.equals("百色学院简介")) {
            resuleMsg = "百色学院是2006年教育部批准成立的实行“区市共建、以市为主”办学体制的普通本科高校。77年来，学校坚持在“老、少、边、山、穷、库”地区办学，凝练了“团结合作、艰苦奋斗、克难攻坚、磨砺成才”的“石磨精神”，走出一条艰苦创业的发展之路，为边疆民族地区的经济发展、社会进步和国防巩固作出巨大贡献。";
        }

        MsgBean entity = new MsgBean();
        entity.setCode(100000);
        entity.setText(resuleMsg);

        getView().ShowNewsData(entity);

    }
}
