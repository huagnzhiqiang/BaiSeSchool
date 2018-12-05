package com.baise.school.ui.main.home;

import com.baise.school.data.entity.TestNews;
import com.baise.school.data.repository.RetrofitUtils;
import com.baise.baselibs.mvp.BaseModel;
import com.baise.baselibs.net.BaseHttpResult;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author 小强
 * @time 2018/6/13 15:35
 * @desc
 */
public class HomeModel extends BaseModel implements HomeContract.Model {
    @Override
    public Observable<BaseHttpResult<List<TestNews>>> getGankData() {
        return RetrofitUtils.getHttpService().getGankData();
    }
}
