package com.baise.school.ui.main.mine;

import com.baise.baselibs.mvp.BasePresenter;
import com.baise.baselibs.net.BaseHttpResult;
import com.baise.baselibs.net.BaseObserver;
import com.baise.baselibs.rx.RxSchedulers;
import com.baise.school.data.entity.LoginEntity;

import java.util.Map;

/**
 * @author 小强
 * @time 2018/6/12 22:57
 * @desc
 */
public class MinePresenter extends BasePresenter<MineContract.Model,MineContract.View> {
    @Override
    protected MineContract.Model createModel() {
        return new MineModel();
    }


}
