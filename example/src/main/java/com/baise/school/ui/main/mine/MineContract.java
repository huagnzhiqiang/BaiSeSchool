package com.baise.school.ui.main.mine;

import com.baise.school.data.entity.LoginEntity;
import com.baise.school.data.entity.MineEntity;
import com.baise.baselibs.mvp.IModel;
import com.baise.baselibs.mvp.IView;
import com.baise.baselibs.net.BaseHttpResult;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author 小强
 * @time  2018/6/12 22:57
 * @desc 契约类
 */
public interface MineContract {


    interface View extends IView {
        void showData(MineEntity testNews);
        void showLoginData(LoginEntity data);

    }

    interface Model extends IModel {
        Observable<BaseHttpResult<MineEntity>> getMineData();
        Observable<BaseHttpResult<LoginEntity>> getLoginData(Map<String,String> map);
    }

}
